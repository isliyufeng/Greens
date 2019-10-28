package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ResultVo;

public interface AddressService extends IService<Commodity> {
    ResultVo allAddress(Integer uid);
}
