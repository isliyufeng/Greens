package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.ShAddress;

public interface AddressService extends IService<Commodity> {
    ResultVo allAddress(Integer uid);

    ResultVo insertAddress(ShAddress shAddress);

    ResultVo numberAddress(Integer uid);

    ResultVo delAddress(Integer id);
}
