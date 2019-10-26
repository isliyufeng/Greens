package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.service.OneTypeService;
import com.cxk.cai.entity.OneType;
import com.cxk.cai.mapper.OneTypeMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OneTypeServiceImpl extends ServiceImpl<OneTypeMapper, OneType> implements OneTypeService {
    @Override
    public List<OneType> getOneType() {
        List<OneType> oneTypes = getBaseMapper().selectList(new QueryWrapper<>());
        return oneTypes;
    }
}
