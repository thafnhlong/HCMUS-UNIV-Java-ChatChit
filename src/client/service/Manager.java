package client.service;

import client.prototcol.TcpClient;

public class Manager {

    private static Manager tis;
    private TcpClient client;
    private String hostname;
    private int port;

    private Manager() {
        client = new TcpClient();
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

    public void reconnect(){
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
