package server.service;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket client;
    private BufferedReader in;
    private BufferedWriter out;

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String ret = in.readLine();
                if(ret==null){
                    Logger.writeln("Client ... has exited");
                    return;
                }
                out.write(ret);
                out.flush();
            } catch (IOException e) {
                break;
            }
        }
    }
}
