package client.repo;

import entity.Account;
import entity.StatusFileTransfer;
import server.repo.AccountRepo;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class FileDownloadRepo {
    private static List<StatusFileTransfer> db;

    private static FileDownloadRepo tis;

    private FileDownloadRepo() {
        db = new LinkedList<>();
    }

    public static FileDownloadRepo getInstance() {
        if (tis == null) {
            tis = new FileDownloadRepo();
        }
        return tis;
    }

    public StatusFileTransfer addFileTransfer(int index) {
        var sft = new StatusFileTransfer(index, "0%", false);
        synchronized (db) {
            db.add(sft);
        }
        return sft;
    }

    public void forEachRate(Consumer<StatusFileTransfer> fn) {
        synchronized (db) {
            var itr = db.iterator();
            while (itr.hasNext()) {
                var item = itr.next();
                fn.accept(item);
                if (item.isSuccess()) {
                    itr.remove();
                }
            }
        }
    }
}
