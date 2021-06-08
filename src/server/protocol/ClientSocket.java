package server.protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            out.write(inp);
            out.flush();
        } catch (IOException e) {
        }
    }

    public void disconnect() {
        try {
            client.close();
        } catch (IOException e) {
        }
    }
}
