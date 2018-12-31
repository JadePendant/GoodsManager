package com.shop.mapper;

import com.shop.domain.Record;

import java.util.List;

public interface RecordMapper {
    //查询所有记录信息
    public List<Record> getAllRecord();
    //新增记录
        public void addRecord(Record record);
    //删除记录
    public void deleteRecord(Integer id);
    //修改商品
    public void updateRecord(Record record);
}
