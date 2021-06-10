package client.service;

import client.gui.listener.IMessageReceiverListener;
import client.prototcol.TcpClient;
import entity.Message;
import entity.MessageType;
import entity.message.FileUploadMessage;
import entity.message.TextMessage;

import java.io.File;

public class Manager {

    private static Manager tis;
    private TcpClient client;
    private String hostname;
    private int port;
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

    public void sendFileMessage(File inp) {
        var filemessage = new FileUploadMessage(inp.getName(), inp.length());
        var message = new Message(MessageType.FILEUP, filemessage, "");
        client.sendString(message.toString());
    }

    public void reconnect() {
        client.disconnect();
        client.connect(hostname, port);
    }

    public boolean login(String username, String password) {
        client.sendString("1\t" + username + "\t" + password);
        return client.readString().equals("1");
    }

    public void register(String username, String password) {
        client.sendString("0\t" + username + "\t" + password);
    }
}
