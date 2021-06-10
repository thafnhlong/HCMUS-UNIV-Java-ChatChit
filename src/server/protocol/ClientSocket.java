package server.protocol;

import entity.Config;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    private Socket client;
    private BufferedReader in;
    private BufferedWriter out;

    public ClientSocket(Socket client) {
        this.client = client;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readString() {
        try {
            return in.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    public void sendString(String inp) {
        try {
            out.write(inp + "\n");
            out.flush();
        } catch (IOException e) {
        }
    }

    public byte[] readAllBytes() {
        try {
            return client.getInputStream().readAllBytes();
        } catch (IOException e) {
        }
        return null;
    }

    public byte[] readBytes(){
        var buffer = new byte[Config.BufferSize];
        try {
            int retSize = client.getInputStream().read(buffer);
            if (retSize!=-1){
                var realBuffer = new byte[retSize];
                System.arraycopy(buffer,0,realBuffer,0,retSize);
                return realBuffer;
            }
        } catch (IOException e) {
        }
        return null;
    }

    public void disconnect() {
        try {
            client.close();
        } catch (IOException e) {
        }
    }
}
