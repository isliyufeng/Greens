package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.OneType;
import java.util.List;

public interface OneTypeService extends IService<OneType> {
    /**
     * 获取一级分类
     *
     * @return
     */
    List<OneType> getOneType();
}
