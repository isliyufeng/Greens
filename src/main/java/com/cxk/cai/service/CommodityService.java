package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Commodity;

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
}
