package server.protocol;


import entity.Config;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    private int port;
    private DatagramSocket serverSocket;

    public boolean create(int port){
        if(serverSocket!=null){
            disconnect();
        }
        try {
            serverSocket = new DatagramSocket(port);
        } catch (IOException e) {
            return false;
        }
        this.port = port;
        return true;
    }

    public UdpResult getNextRequest(){
        var ret = new byte[Config.PacketSize];
        var dpRead = new DatagramPacket(ret, Config.PacketSize);
        try {
            serverSocket.receive(dpRead);
        } catch (IOException e) {
            return null;
        }
        return new UdpResult(dpRead);
    }

    public void disconnect(){
        serverSocket.close();
        try {
            serverSocket.close();
        } catch (Exception e) {
        }
        serverSocket=null;
    }
}
