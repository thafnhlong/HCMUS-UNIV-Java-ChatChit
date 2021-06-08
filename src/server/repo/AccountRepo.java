package server.repo;

import java.util.LinkedList;
import java.util.List;

import entity.Account;

public class AccountRepo {
    private static List<Account> db;

    private static AccountRepo tis;

    private AccountRepo() {
        db = new LinkedList<>();
    }

    public static AccountRepo getInstance() {
        if (tis == null) {
            tis = new AccountRepo();
        }
        return tis;
    }

    public Account getAccountByUP(String username, String password) {
        Account ret = null;
        for (Account account : db) {
            if (account.getPassword().equals(username) && account.getPassword().equals(password)) {
                ret = account;
                break;
            }
        }
        return ret;
    }

    public void addAccount(Account account) {
        synchronized(db){
            db.add(account);
        }
    }
}
