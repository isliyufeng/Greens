package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Cat;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface CatService extends IService<Cat> {
    /**
     * 添加购物车
     *
     * @param cat
     * @return
     */
    boolean add(Cat cat);

    /**
     * 删除购物车中的商品
     *
     * @param id
     * @return
     */
    boolean del(Integer id);

    /**
     * 查询购物车中所有的商品
     *
     * @param id
     * @return
     */
    List<Cat> selectAll(Integer id);

    /**
     * 修改购物车中商品的数量
     *
     * @param cat
     * @return
     */
    boolean updateByNumber(Cat cat);

    /**
     * 根据id查询购物车商品信息
     *
     * @param id
     * @return
     */
    Cat selectById(Integer id);
}
