package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import server.protocol.TcpServer;
import server.protocol.UdpServer;
import server.service.ClientHandler;
import server.service.DownloadHandler;

public class Main {
    private BufferedReader br;

    public Main() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.valueOf(br.readLine());
            } catch (IOException e) {
            }
        }
    }

    public void run() {
        System.out.println("This is Server");

        var server = new TcpServer();
        while (true) {
            System.out.print("Which port chat: ");
            int port = readInt();
            if (server.create(port)) {
                break;
            }
            System.out.println("Port has been used");
        }

        var dlServer = new UdpServer();

        while (true) {
            System.out.print("Which port download: ");
            int port = readInt();
            if (dlServer.create(port)) {
                break;
            }
            System.out.println("Port has been used");
        }

        new Thread(() -> {
            while (true) {
                var client = server.getNewClient();
                new ClientHandler(client).start();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                var client = dlServer.getNextRequest();
                new DownloadHandler(client).start();
            }
        }).start();

        System.out.println("Press enter to exit.");
        try {
            System.in.read();
        } catch (IOException e) {
        }
        System.exit(0);
    }

}
