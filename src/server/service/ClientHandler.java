package server.service;

import java.io.*;
import java.net.Socket;

import entity.Account;
import server.protocol.ClientInfo;
import server.protocol.ClientSocket;
import server.repo.AccountRepo;
import server.repo.ClientRepo;

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
        initClient();

        while (true) {

            String mes = client.readString();
            if(mes==null){
                byebye();
                break;
            }
            clientRepo.forEach((ClientInfo clientInfo)->{
                if (!clientInfo.equals(this.clientInfo)){
                    clientInfo.getClientSocket().sendString(mes);                    
                }
            });

        }
    }

    void initClient() {
        while (true) {
            var tupa = client.readString().split("\\r");
            var isLogin = tupa[0];
            var username = tupa[1];
            var password = tupa[2];

            if (isLogin.equals("0")) {
                accountRepo.addAccount(new Account(username, password));
                client.sendString("1");
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
    }

    void byebye(){
        client.disconnect();
    }
}
