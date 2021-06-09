package client;

import client.gui.ConnectionForm;

public class Main {
    public void run(){
        System.out.println("This is Client");
        new ConnectionForm().setVisible(true);
    }
}
