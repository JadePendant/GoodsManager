package com.shop.service;
import com.shop.domain.Goods;
import java.util.List;

public interface GoodsService {
    public List<Goods> getAllGoods();
    public int addGoods(Goods goods);
    public void deleteGoods(Integer id);
    public void updateGoods(Goods goods);
    public List<Goods> searchGoods(String goodsName);
    public List<Goods> searchGoodsWithUser(String username);
    public List<Goods> searchGoodsWithUserGoods(String goodsName,String username);
}
