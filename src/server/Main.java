package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import server.protocol.TcpServer;
import server.service.ClientHandler;

public class Main {
    private BufferedReader br;

    public Main() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private int readInt(){
        while(true){
            try {
                return Integer.valueOf(br.readLine());
            } catch (IOException e) {
            }
        }
    }

    public void run() {
        System.out.println("This is Server");

        System.out.print("Which port listener: ");
        int port = readInt();

        var server = new TcpServer();
        server.create(port);

        while(true){
            var client = server.getNewClient();
            new ClientHandler(client).start();
        }
    }
}
