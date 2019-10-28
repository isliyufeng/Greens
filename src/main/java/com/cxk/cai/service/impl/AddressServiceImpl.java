package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.ShAddress;
import com.cxk.cai.mapper.AddressMapper;
import com.cxk.cai.mapper.CommodityMapper;
import com.cxk.cai.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public ResultVo allAddress(Integer uid) {
        if (uid != null && !"".equals(uid)) {
            //根据用户ID查询用户的收货地址信息
            List<ShAddress> shAddressList = addressMapper.allAddress(uid);
            return ResultVo.setSUCCESS(shAddressList);
        } else {
            return ResultVo.setERROR();
        }
    }
}
