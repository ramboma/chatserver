package com.rambosoft.demo.chatserver1.model;

/**
 * Created by rambo on 2019/3/23.
 */
public class ChatMessage {
    private String message;
    private String sender;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    private MessageType type;
    public enum MessageType{JOIN,CHAT,LEVEL}

}
