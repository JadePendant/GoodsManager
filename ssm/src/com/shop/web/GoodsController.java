package com.shop.web;

import com.shop.domain.Goods;
import com.shop.domain.GoodsMessage;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsController {
    /*注入业务层*/
    @Autowired
    private GoodsService goodsService;

    //获取所有商品接口
    @RequestMapping("goods")
    @ResponseBody
    public GoodsMessage getAllGoods(){
        List<Goods> list =goodsService.getAllGoods();
        GoodsMessage goodsMessage = new GoodsMessage();
        goodsMessage.setOk(1);
        goodsMessage.setMessage("查询成功");
        goodsMessage.setData(list);
        return goodsMessage;
    }
    //添加商品
    @RequestMapping(value = {"/addgoods"},method = {RequestMethod.POST})
    @ResponseBody
    public GoodsMessage add(Goods goods){
        System.out.println(goods);
        goodsService.addGoods(goods);
        GoodsMessage goodsMessage = new GoodsMessage();
        goodsMessage.setOk(1);
        goodsMessage.setMessage("添加成功");
        return goodsMessage;
    }
    //删除商品
    @RequestMapping("deletegoods")
    @ResponseBody
    public GoodsMessage delete(Integer id){
        goodsService.deleteGoods(id);
        GoodsMessage goodsMessage = new GoodsMessage();
        goodsMessage.setOk(1);
        goodsMessage.setMessage("删除成功");
        return goodsMessage;
    }
    //修改商品
    @RequestMapping(value = {"/updategoods"},method = {RequestMethod.POST})
    @ResponseBody
    public GoodsMessage update(Goods goods){

        goodsService.updateGoods(goods);
        GoodsMessage goodsMessage = new GoodsMessage();
        goodsMessage.setOk(1);
        goodsMessage.setMessage("更改成功");
        return goodsMessage;
    }
    //查找商品
    @RequestMapping("searchgoods")
    @ResponseBody
    public GoodsMessage search(String goodsName){

        GoodsMessage goodsMessage = new GoodsMessage();
        List<Goods> goods = goodsService.searchGoods(goodsName);
        if(goods==null)
        {
            goodsMessage.setOk(0);
            goodsMessage.setMessage("无此商品");
        }
        else{
            goodsMessage.setOk(1);
            goodsMessage.setMessage("查询成功");
            goodsMessage.setData(goods);
        }
        return goodsMessage;
    }
    //根据用户名查找商品
    @RequestMapping("searchgoodsbyuser")
    @ResponseBody
    public GoodsMessage searchByUser(String username){

        GoodsMessage goodsMessage = new GoodsMessage();
        List<Goods> goods = goodsService.searchGoodsWithUser(username);
        if(goods==null)
        {
            goodsMessage.setOk(0);
            goodsMessage.setMessage("无商品");
        }
        else{
            goodsMessage.setOk(1);
            goodsMessage.setMessage("查询成功");
            goodsMessage.setData(goods);
        }
        return goodsMessage;
    }
    //根据用户名和姓名查找商品
    @RequestMapping("searchgoodsbyusergoods")
    @ResponseBody
    public GoodsMessage searchByUserGoods(String goodsName,String username){
        GoodsMessage goodsMessage = new GoodsMessage();
        List<Goods> goods = goodsService.searchGoodsWithUserGoods(goodsName,username);
        if(goods==null)
        {
            goodsMessage.setOk(0);
            goodsMessage.setMessage("无商品");
        }
        else{
            goodsMessage.setOk(1);
            goodsMessage.setMessage("查询成功");
            goodsMessage.setData(goods);
        }
        return goodsMessage;
    }
}
