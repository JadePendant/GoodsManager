package com.shop.web;
import com.shop.domain.Record;
import com.shop.domain.RecordMessage;
import com.shop.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;
    //获取所有记录接口
    @RequestMapping("record")
    @ResponseBody
    public RecordMessage getAllRecord(){
        List<Record> list =recordService.getAllRecord();
        RecordMessage recordMessage = new RecordMessage();
        recordMessage.setOk(1);
        recordMessage.setMessage("查询成功");
        recordMessage.setData(list);
        return recordMessage;
    }
    //添加记录
    @RequestMapping(value = {"/addrecord"},method = {RequestMethod.POST})
    @ResponseBody
    public RecordMessage add(Record record){
        System.out.println(record);
        recordService.addRecord(record);
        RecordMessage recordMessage = new RecordMessage();
        recordMessage.setOk(1);
        recordMessage.setMessage("添加成功");
        return recordMessage;
    }
    //删除记录
    @RequestMapping("deleterecord")
    @ResponseBody
    public RecordMessage delete(Integer id){
        recordService.deleteRecord(id);
        RecordMessage recordMessage = new RecordMessage();
        recordMessage.setOk(1);
        recordMessage.setMessage("删除成功");
        return recordMessage;
    }
    //修改记录
    @RequestMapping(value = {"/updaterecord"},method = {RequestMethod.POST})
    @ResponseBody
    public RecordMessage update(Record record){

        recordService.updateRecord(record);
        RecordMessage recordMessage = new RecordMessage();
        recordMessage.setOk(1);
        recordMessage.setMessage("更改成功");
        return recordMessage;
    }
}
