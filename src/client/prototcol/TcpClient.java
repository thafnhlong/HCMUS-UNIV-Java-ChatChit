package client.prototcol;

import java.io.*;
import java.net.Socket;

import entity.Config;

public class TcpClient {
    private Socket client;
    private BufferedReader in;
    private BufferedWriter out;
    private InputStream is;
    private OutputStream os;

    public boolean connect(String hostname, int port) {
        try {
            this.client = new Socket(hostname, port);
            is = client.getInputStream();
            os = client.getOutputStream();
            in = new BufferedReader(new InputStreamReader(is));
            out = new BufferedWriter(new OutputStreamWriter(os));
        } catch (Exception e) {
            return false;
        }
        return true;
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
