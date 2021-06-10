package server.service;

import java.net.Socket;

import entity.Config;
import server.protocol.ClientSocket;
import server.utils.FileUtils;

public class DownloadHandler extends Thread {
    private ClientSocket client;

    public DownloadHandler(Socket client) {
        this.client = new ClientSocket(client);
    }

    @Override
    public void run() {
        var fileName = client.readString();
        if(fileName==null){
            closeConnection();
        }
        
        FileUtils.StreamFile(fileName, Config.BufferSize, (data)->{
            client.sendBytes(data);
        });

        closeConnection();
    }
    void closeConnection() {
        client.disconnect();
    }
}
