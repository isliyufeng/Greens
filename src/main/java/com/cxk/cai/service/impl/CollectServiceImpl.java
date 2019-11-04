package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Collect;
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
            //查询用户收藏
            List<Collect> collectList = collectMapper.SelectUserCollect(uid);
            return ResultVo.setSUCCESS(collectList);
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo userCollect(Integer uid, Integer cid) {
        if (uid != null && !"".equals(uid) && cid != null && !"".equals(cid)) {
            //查看用户是否收藏过
            Collect collect = new Collect();
            collect.setUid(uid);
            collect.setCid(cid);
            int result = collectMapper.selectCollect(collect);
            if (result == 1) {
                return ResultVo.setERROR();
            } else {
                //没有收藏便执行以下方法，收藏商品
                int collectList = collectMapper.userCollect(collect);
                return ResultVo.setSUCCESS(collectList);
            }
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo delUserCollect(Integer uid, Integer cid) {
        Collect collect = new Collect();
        collect.setUid(uid);
        collect.setCid(cid);
        //查看收藏是否存在
        int i = collectMapper.selectCollect(collect);
        if (i == 1) {
            return ResultVo.setSUCCESS(collectMapper.delUserCollect(collect));
        }
        return ResultVo.setERROR();
    }
}
