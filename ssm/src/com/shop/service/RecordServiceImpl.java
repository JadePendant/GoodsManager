package com.shop.service;

import com.shop.domain.Record;
import com.shop.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("RecordService")
@Transactional
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public List<Record> getAllRecord() {
        List<Record> list =null;
        list = recordMapper.getAllRecord();
        return list;
    }

    @Override
    public int addRecord(Record record) {
        recordMapper.addRecord(record);
        return 1;
    }

    @Override
    public void deleteRecord(Integer id) {
        recordMapper.deleteRecord(id);
    }

    @Override
    public void updateRecord(Record record) {
        recordMapper.updateRecord(record);
    }
}
