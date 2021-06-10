package server.service;

import java.io.*;
import java.net.Socket;

import entity.Account;
import entity.Message;
import entity.MessageType;
import entity.message.FileMessage;
import entity.message.FileUploadMessage;
import server.protocol.ClientInfo;
import server.protocol.ClientSocket;
import server.repo.AccountRepo;
import server.repo.ClientRepo;
import server.utils.FileUtils;
import server.utils.IdGenerate;

public class ClientHandler extends Thread {
    private ClientSocket client;
    private ClientRepo clientRepo;
    private AccountRepo accountRepo;
    private ClientInfo clientInfo;

    public ClientHandler(Socket client) {
        this.client = new ClientSocket(client);
        clientRepo = ClientRepo.getInstance();
        accountRepo = AccountRepo.getInstance();
    }

    @Override
    public void run() {
        if (!initClient()) {
            return;
        }

        while (true) {

            String mes = client.readString();
            if (mes == null) {
                byebye();
                break;
            }
            var message = new Message(mes);
            if (message.getType() == MessageType.FILEUP) {

                var fum = (FileUploadMessage) message.getData();
                var tmpName = clientInfo.getAccount().getUsername() + "_" + IdGenerate.generate() + "_"
                        + fum.getFileName();

                if (!downloadToServer(tmpName, fum)) {
                    byebye();
                    break;
                }

                var fileMessage = new FileMessage(tmpName, fum.getFileName(), fum.getFileSize()).toString();
                message.setType(MessageType.FILE);
                message.setData(fileMessage);
            }
            message.setAuthor(clientInfo.getAccount().getUsername());

            String nextMes = message.toString();
            clientRepo.forEach((ClientInfo clientInfo) -> {
                if (message.getType() == MessageType.FILE || !clientInfo.equals(this.clientInfo)) {
                    clientInfo.getClientSocket().sendString(nextMes);
                }
            });

        }
    }

    boolean downloadToServer(String tmpName, FileUploadMessage data) {
        long receiveByte = 0L;
        FileUtils.touchFile(tmpName);
        while (true) {
            var ret = client.readBytes();
            if (ret == null) {
                return false;
            }
            FileUtils.appendToFile(tmpName, ret);
            receiveByte += ret.length;
            if (receiveByte == data.getFileSize())
                break;
        }
        return true;
    }

    boolean initClient() {
        while (true) {
            var retStr = client.readString();
            if (retStr == null) {
                closeConnection();
                return false;
            }
            var tupa = retStr.split("\\t");
            var isLogin = tupa[0];
            var username = tupa[1];
            var password = tupa[2];

            if (isLogin.equals("0")) {
                accountRepo.addAccount(new Account(username, password));
            } else {
                var account = accountRepo.getAccountByUP(username, password);
                if (account == null) {
                    client.sendString("0");
                } else {
                    client.sendString("1");
                    this.clientInfo = new ClientInfo(account, client);
                    clientRepo.addClient(this.clientInfo);
                    break;
                }
            }
        }
        Logger.writeln("Client " + clientInfo.getAccount().getUsername() + " has joined server");
        return true;
    }

    void closeConnection() {
        client.disconnect();
    }

    void byebye() {
        client.disconnect();
        clientRepo.removeClient(this.clientInfo);
        Logger.writeln("Client " + clientInfo.getAccount().getUsername() + " has left server");
    }

}
