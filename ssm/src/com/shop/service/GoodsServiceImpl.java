package com.shop.service;

import com.shop.domain.Goods;
import com.shop.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("GoodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> list =null;
        list = goodsMapper.getAllGoods();
        return list;
    }

    @Override
    public int addGoods(Goods goods) {
            goodsMapper.addGoods(goods);
            return 1;
    }

    @Override
    public void deleteGoods(Integer id) {
        goodsMapper.deleteGoods(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }

    @Override
    public List<Goods> searchGoods(String goodsName) {
        return goodsMapper.getGoodsWithName(goodsName);
    }

    @Override
    public List<Goods> searchGoodsWithUser(String username) {
        return goodsMapper.getGoodsWithUsername(username);
    }

    @Override
    public List<Goods> searchGoodsWithUserGoods(String goodsName, String username) {
        return goodsMapper.getGoodsWithUserGoods(goodsName,username);
    }
}
