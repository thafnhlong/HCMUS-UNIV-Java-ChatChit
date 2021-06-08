package server.protocol;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private int port;
    private ServerSocket serverSocket;

    public boolean create(int port){
        if(serverSocket!=null){
            disconnect();
        }
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            return false;
        }
        this.port = port;
        return true;
    }

    public Socket getNewClient(){
        try {
            return serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    } 

    public void disconnect(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverSocket=null;
    }
}
