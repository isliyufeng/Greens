package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.TwoType;
import com.cxk.cai.mapper.TwoTypeMapper;
import com.cxk.cai.service.TwoTypeService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Service
public class TwoTypeServiceImpl extends ServiceImpl<TwoTypeMapper, TwoType> implements TwoTypeService {
    @Override
    public List<TwoType> getTwoTypeByOneId(Integer id) {
        List<TwoType> twoTypes = getBaseMapper().selectList(new QueryWrapper<TwoType>().eq("oneid", id));
        return twoTypes;
    }
}
