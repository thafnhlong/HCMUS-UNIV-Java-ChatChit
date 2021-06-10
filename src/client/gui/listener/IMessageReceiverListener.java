package client.gui.listener;

import entity.Message;

public interface IMessageReceiverListener {
    void process(Message message);
}
