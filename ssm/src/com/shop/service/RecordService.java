package com.shop.service;

import com.shop.domain.Record;

import java.util.List;

public interface RecordService {
    public List<Record> getAllRecord();
    public int addRecord(Record record);
    public void deleteRecord(Integer id);
    public void updateRecord(Record record);
}
