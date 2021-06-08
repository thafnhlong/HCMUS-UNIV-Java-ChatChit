package server.service;

import server.protocol.UdpResult;

public class DownloadHandler extends Thread {
    UdpResult result;

    public DownloadHandler(UdpResult result) {
        this.result = result;
    }

    @Override
    public void run() {
        if (result == null)
            return;

    }
}
