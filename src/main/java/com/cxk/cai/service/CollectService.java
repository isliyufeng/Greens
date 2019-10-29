package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ResultVo;

public interface CollectService extends IService<Commodity> {
    /**
     * 查询用户收藏的商品
     * @param uid
     * @return
     */
    ResultVo SelectUserCollect(Integer uid);

    /**
     * 添加用户收藏
     * @param uid
     * @param cid
     * @return
     */
    ResultVo userCollect(Integer uid, Integer cid);

    /**
     * 取消用户收藏
     * @param uid
     * @param cid
     * @return
     */
    ResultVo delUserCollect(Integer uid, Integer cid);
}
