package server.protocol;

import entity.Config;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    private final Socket client;
    private BufferedReader in;
    private BufferedWriter out;
    private InputStream is;
    private OutputStream os;

    public ClientSocket(Socket client) {
        this.client = client;
        try {
            is = client.getInputStream();
            os = client.getOutputStream();
            in = new BufferedReader(new InputStreamReader(is));
            out = new BufferedWriter(new OutputStreamWriter(os));
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
            return is.readAllBytes();
        } catch (IOException e) {
        }
        return null;
    }

    public byte[] readBytes() {
        var buffer = new byte[Config.BufferSize];
        try {
            int retSize = is.read(buffer);
            if (retSize != -1) {
                var realBuffer = new byte[retSize];
                System.arraycopy(buffer, 0, realBuffer, 0, retSize);
                return realBuffer;
            }
        } catch (IOException e) {
        }
        return null;
    }

    public void sendBytes(byte[] data){
        try {
            os.write(data);
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
