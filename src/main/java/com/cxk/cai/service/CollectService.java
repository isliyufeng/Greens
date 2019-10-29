package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ResultVo;

public interface CollectService extends IService<Commodity> {
    ResultVo SelectUserCollect(Integer uid);

    ResultVo userCollect(int uid, int cid);
}
