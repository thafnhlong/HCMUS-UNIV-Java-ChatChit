package entity;

public class StatusFileTransfer {
    private int index;
    private String status;
    private boolean isSuccess;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public StatusFileTransfer(int index, String status, boolean isSuccess) {
        this.index = index;
        this.status = status;
        this.isSuccess = isSuccess;
    }
}
