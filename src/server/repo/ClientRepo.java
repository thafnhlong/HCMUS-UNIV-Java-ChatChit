package server.repo;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import server.protocol.ClientInfo;

public class ClientRepo {
    private static List<ClientInfo> db;

    private static ClientRepo tis;

    private ClientRepo() {
        db = new LinkedList<>();
    }

    public static ClientRepo getInstance() {
        if (tis == null) {
            tis = new ClientRepo();
        }
        return tis;
    }

    public void addClient(ClientInfo clientInfo) {
        synchronized (db) {
            db.add(clientInfo);
        }
    }

    public void removeClient(ClientInfo clientInfo) {
        synchronized (db) {
            db.remove(clientInfo);
        }
    }

    public void forEach(Consumer<ClientInfo> fn){
        synchronized(db){
            db.forEach(fn);
        }
    }
}