package entity;

import entity.message.FileMessage;
import entity.message.FileUploadMessage;
import entity.message.TextMessage;

public class Message {
    private MessageType type;
    private Object data;
    private String author;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Message(MessageType type, Object data, String author) {
        this.type = type;
        this.data = data;
        this.author = author;
    }

    public Message(String inp) {
        var tp = inp.substring(0, inp.indexOf("`"));
        var dataString = inp.substring(inp.indexOf("`") + 1);
        type = MessageType.valueOf(tp);
        author = inp.substring(inp.lastIndexOf("`") + 1);

        switch (type) {
            case FILE:
                this.data = new FileMessage(dataString);
                break;
            case FILEUP:
                this.data = new FileUploadMessage(dataString);
                break;
            case TEXT:
                this.data = new TextMessage(dataString);
                break;
        }
    }

    @Override
    public String toString() {
        return type+"`"+data.toString()+"`"+author;
    }
}
