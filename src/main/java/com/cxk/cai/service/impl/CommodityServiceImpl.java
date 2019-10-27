package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.mapper.CommodityMapper;
import com.cxk.cai.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    @Autowired
    CommodityMapper mapper;

    @Override
    public List<Commodity> getNewCommodity(Integer num) {
        return mapper.getNewCommodity(num);
    }
}