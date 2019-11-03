package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.CommodityVo;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.mapper.CommodityInventoryMapper;
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

    @Autowired
    CommodityInventoryMapper inventoryMapper;

    @Override
    public List<Commodity> getNewCommodity(Integer num) {
        return mapper.getNewCommodity(num);
    }

    @Override
    public List<Commodity> getCommodity(Integer id, Integer num) {
        return mapper.getCommodity(id, num);
    }

    @Override
    public Commodity getCommodityInfoById(Integer id) {
        return getBaseMapper().selectById(id);
    }

    @Override
    public List<Commodity> selectCommodityByName(String name) {
        return mapper.selectCommodityByName(name);

    }

    @Override
    public CommodityVo selectCommodityInventoryById(Integer cid) {
        return mapper.getInventory(cid);
    }

    @Override
    public boolean updateInventory(Integer[] cid) {
        for (Integer id : cid) {
            CommodityVo inventory = mapper.getInventory(id);
            System.out.println(inventory);
            if (inventory.getInventory() - 1 >= 0) {
                int i = inventoryMapper.updateInventory(id, inventory.getInventory() - 1, inventory.getSellnumber() + 1);
                if (i <= 0) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        }
        return false;
    }


}
