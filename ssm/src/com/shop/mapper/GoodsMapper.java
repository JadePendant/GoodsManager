package com.shop.mapper;
import com.shop.domain.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GoodsMapper {
    //查询所有商品信息
    public List<Goods> getAllGoods();
    //新增商品
    public void addGoods(Goods goods);
    //删除商品
    public void deleteGoods(Integer id);
    //修改商品
    public void updateGoods(Goods goods);
    //根据名称查询商品
    public List<Goods> getGoodsWithName(String goodsName);
    //根据用户名查询商品
    public List<Goods> getGoodsWithUsername(String username);
    //跟据用户和商品名称查询商品
    public List<Goods> getGoodsWithUserGoods(@Param("goodsName") String goodsName, @Param("username") String username);
}
