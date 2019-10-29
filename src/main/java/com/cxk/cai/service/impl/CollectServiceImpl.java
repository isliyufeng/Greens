package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Collect;
import com.cxk.cai.entity.CollectVo;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.mapper.CollectMapper;
import com.cxk.cai.mapper.CommodityMapper;
import com.cxk.cai.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public ResultVo SelectUserCollect(Integer uid) {
        if (uid != null && !"".equals(uid)) {
            List<Collect> collectList = collectMapper.SelectUserCollect(uid);
            return ResultVo.setSUCCESS(collectList);
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo userCollect(int uid, int cid) {
        Collect collect = new Collect();
        collect.setUid(uid);
        collect.setCid(cid);
        if (collect != null && !"".equals(collect)) {
            List<Collect> collectList = collectMapper.userCollect(collect);
            return ResultVo.setSUCCESS(collectList);
        } else {
            return ResultVo.setERROR();
        }
    }
}
