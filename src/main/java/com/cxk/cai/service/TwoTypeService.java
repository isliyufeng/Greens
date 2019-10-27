package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.TwoType;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface TwoTypeService extends IService<TwoType> {
    /**
     * 获取二级菜单
     *
     * @return
     */
    List<TwoType> getOneType();
}
