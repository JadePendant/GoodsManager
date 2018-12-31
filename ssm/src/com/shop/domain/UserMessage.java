package com.shop.domain;

import java.util.List;

public class UserMessage {
    private int ok;
    private String message;
    private User user;
    private List<User> data;

    @Override
    public String toString() {
        return "UserMessage{" +
                "ok=" + ok +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", data=" + data +
                '}';
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
