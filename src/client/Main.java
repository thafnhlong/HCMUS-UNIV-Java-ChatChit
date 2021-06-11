package client;

import client.gui.ConnectionForm;
import entity.Config;
import client.utils.FileUtils;

public class Main {

    public Main(){
        FileUtils.createIfNotExistFolder(Config.clientDownloadFolder);
    }

    public void run(){
        System.out.println("This is Client");
        new ConnectionForm().setVisible(true);
    }
}
