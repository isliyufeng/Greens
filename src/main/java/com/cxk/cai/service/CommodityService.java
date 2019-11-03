package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.CommodityVo;
import com.cxk.cai.entity.ResultVo;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface CommodityService extends IService<Commodity> {
    /**
     * 降序获取新上市商品
     *
     * @param num 需要查询的条数
     * @return
     */
    List<Commodity> getNewCommodity(Integer num);

    /**
     * 根据商品二级分类id，查询商品信息
     *
     * @param id  二级分类id
     * @param num 需要查询的条数
     * @return
     */
    List<Commodity> getCommodity(Integer id, Integer num);

    /**
     * 根据商品id获取商品信息
     *
     * @param id 商品id
     * @return
     */
    Commodity getCommodityInfoById(Integer id);

    /**
     * 根据关键字查询商品
     *
     * @param name
     * @return
     */
    List<Commodity> selectCommodityByName(String name);

    /**
     * 获取指定id商品的库存
     *
     * @param cid
     * @return
     */
    CommodityVo selectCommodityInventoryById(Integer cid);

    /**
     * 卖出商品修改库存
     *
     * @param cid
     * @return
     */
    boolean updateInventory(Integer[] cid);


}
