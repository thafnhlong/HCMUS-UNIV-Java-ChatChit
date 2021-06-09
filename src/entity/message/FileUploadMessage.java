package entity.message;

import java.io.Serializable;

public class FileUploadMessage {
    private String fileName;
    private long fileSize;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public FileUploadMessage(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public FileUploadMessage(String data){
        var dataA = data.split(":");
        fileName = dataA[0];
        fileSize = Long.valueOf(dataA[1]);
    }

    @Override
    public String toString() {
        return fileName+":"+fileSize;
    }
}
