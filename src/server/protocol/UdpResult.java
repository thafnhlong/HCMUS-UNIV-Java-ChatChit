package server.protocol;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class UdpResult {
    private byte[] data;
    private InetAddress iadd;
    private int port;

    public UdpResult(DatagramPacket dpRead) {
        this.data = dpRead.getData();
        this.iadd = dpRead.getAddress();
        this.port = dpRead.getPort();
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public InetAddress getIadd() {
        return iadd;
    }

    public void setIadd(InetAddress iadd) {
        this.iadd = iadd;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
