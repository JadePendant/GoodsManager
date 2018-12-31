package com.shop.domain;

import java.util.List;

public class GoodsMessage {
    private int ok;
    private String message;
    private Goods goods;
    private List<Goods> data;

    @Override
    public String toString() {
        return "GoodsMessage{" +
                "ok=" + ok +
                ", message='" + message + '\'' +
                ", goods=" + goods +
                ", data=" + data +
                '}';
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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Goods> getData() {
        return data;
    }

    public void setData(List<Goods> data) {
        this.data = data;
    }


}
