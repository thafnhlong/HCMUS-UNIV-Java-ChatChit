package entity;

public class Config {
    public static final int PacketSize = 64*1024;
    public static final int BufferSize = 32*1024;
    public static final int RefreshTime = 1000;
    public static final String clientDownloadFolder = "./files/";
    public static final String serverDownloadFolder = "./tmp/";

    public static int DownloadPort;
}
