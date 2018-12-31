package com.shop.domain;
public class Record {
    private int id;
    private String goodsName;
    private String username;
    private int number;
    private String type;
    private String state;

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", username='" + username + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
