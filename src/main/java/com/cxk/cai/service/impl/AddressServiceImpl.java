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

    @Override
    public ResultVo insertAddress(ShAddress shAddress) {
        //添加用户的收货地址，放入list集合中
        int shAddressList = addressMapper.insertAddress(shAddress);
        return ResultVo.setSUCCESS(shAddressList);
    }

    @Override
    public ResultVo numberAddress(Integer uid) {
        if (uid != null && !"".equals(uid)) {
            //根据用户ID查询用户的收货地址个数
            int numberAddress = addressMapper.numberAddress(uid);
            return ResultVo.setSUCCESS(numberAddress);
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo delAddress(Integer id) {
        int delAddress = addressMapper.delAddress(id);
        if (delAddress > 0) {
            return ResultVo.setSUCCESS(delAddress);
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo updateAddress(ShAddress shAddress) {
        int updateAddress = addressMapper.updateAddress(shAddress);
        return ResultVo.setSUCCESS(updateAddress);
    }
}
