package com.shop.domain;

import java.util.List;

public class RecordMessage {
    private int ok;
    private String message;
    private Record record;
    private List<Record> data;

    @Override
    public String toString() {
        return "RecordMessage{" +
                "ok=" + ok +
                ", message='" + message + '\'' +
                ", record=" + record +
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

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Record> getData() {
        return data;
    }

    public void setData(List<Record> data) {
        this.data = data;
    }
}
