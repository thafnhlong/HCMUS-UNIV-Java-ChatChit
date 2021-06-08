package server.protocol;

import entity.Account;

public class ClientInfo {
    private Account account;
    private ClientSocket clientSocket;

    public ClientInfo(Account account, ClientSocket clientSocket) {
        this.account = account;
        this.clientSocket = clientSocket;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ClientSocket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(ClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

}
