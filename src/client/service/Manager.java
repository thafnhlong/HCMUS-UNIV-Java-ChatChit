package client.service;

import client.gui.listener.ICallbackFunction;
import client.gui.listener.IMessageReceiverListener;
import client.prototcol.TcpClient;
import client.repo.FileDownloadRepo;
import entity.Config;
import entity.Message;
import entity.MessageType;
import entity.message.FileUploadMessage;
import entity.message.TextMessage;
import client.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Manager {

    private static Manager tis;
    private TcpClient client;
    private String hostname;
    private int port;
    private int downloadPort;
    private IMessageReceiverListener listener;

    private Manager() {
        client = new TcpClient();
    }

    public IMessageReceiverListener getListener() {
        return listener;
    }

    public void setListener(IMessageReceiverListener listener) {
        this.listener = listener;
    }

    public static Manager getInstance() {
        if (tis == null) {
            tis = new Manager();
        }
        return tis;
    }

    public boolean connect(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        return client.connect(hostname, port);
    }

    public void startListen() {
        new Thread(() -> {
            while (true) {
                if (listener == null)
                    break;
                var msg = client.readString();
                if (msg == null)
                    break;
                var message = new Message(msg);
                listener.process(message);
            }
        }).start();
    }

    public void sendTextMessage(String content) {
        var textmessage = new TextMessage(content);
        var message = new Message(MessageType.TEXT, textmessage, "");
        client.sendString(message.toString());
    }

    public void sendFileMessage(File inp, ICallbackFunction fn) {
        var filemessage = new FileUploadMessage(inp.getName(), inp.length());
        var message = new Message(MessageType.FILEUP, filemessage, "");
        client.sendString(message.toString());
        new Thread(() -> {

            try {
                var fis = new FileInputStream(inp);
                byte[] buffer = new byte[Config.BufferSize];
                int retSize;
                while ((retSize = fis.read(buffer)) > 0) {
                    var realBuffer = new byte[retSize];
                    System.arraycopy(buffer, 0, realBuffer, 0, retSize);
                    client.sendBytes(realBuffer);
                }
                fis.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }

            fn.process();
        }).start();

    }

    public void downloadFile(int index, String fileName, String tmpName, long fileSize) {
        var repo = FileDownloadRepo.getInstance();
        var sft = repo.addFileTransfer(index);

        new Thread(() -> {
            var clientSocket = new TcpClient();
            if (!clientSocket.connect(hostname, downloadPort)) {
                return;
            }
            clientSocket.sendString(tmpName);

            long receiveByte = 0L;
            FileUtils.touchFile(fileName);
            while (true) {
                var ret = clientSocket.readBytes();
                if (ret == null) {
                    sft.setStatus("Error");
                    break;
                }
                FileUtils.appendToFile(fileName, ret);
                receiveByte += ret.length;
                if (receiveByte == fileSize) {
                    sft.setSuccess(true);
                    sft.setStatus("Done");
                    break;
                }
                sft.setStatus(String.valueOf((float) receiveByte / fileSize * 100) + "%");
            }
            clientSocket.disconnect();
        }).start();

    }

    public void reconnect() {
        client.disconnect();
        client.connect(hostname, port);
    }

    public boolean login(String username, String password) {
        client.sendString("1\t" + username + "\t" + password);
        if (client.readString().equals("1")) {
            downloadPort = Integer.valueOf(client.readString());
            return true;
        }
        return false;
    }

    public void register(String username, String password) {
        client.sendString("0\t" + username + "\t" + password);
    }
}
