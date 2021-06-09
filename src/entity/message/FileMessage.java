package entity.message;

public class FileMessage {
    private String tmpName;
    private String fileName;
    private long fileSize;

    public FileMessage(String tmpName, String fileName, long fileSize) {
        this.tmpName = tmpName;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getTmpName() {
        return tmpName;
    }

    public void setTmpName(String tmpName) {
        this.tmpName = tmpName;
    }

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

    public FileMessage(String data){
        var dataA = data.split(":");
        fileName = dataA[0];
        tmpName = dataA[1];
        fileSize = Long.valueOf(dataA[2]);
    }

    @Override
    public String toString() {
        return fileName+":"+tmpName+":"+fileSize;
    }
}
