package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Cat;
import com.cxk.cai.mapper.CatMapper;
import com.cxk.cai.service.CatService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Service
public class CatServiceImpl extends ServiceImpl<CatMapper, Cat> implements CatService {
    @Override
    public boolean add(Cat cat) {
        return getBaseMapper().insert(cat) > 0 ? true : false;
    }

    @Override
    public boolean del(Integer id) {
        return getBaseMapper().deleteById(id) > 0 ? true : false;
    }

    @Override
    public List<Cat> selectAll(Integer id) {
        return getBaseMapper().selectList(new QueryWrapper<Cat>().eq("uid", id));
    }

    @Override
    public boolean updateByNumber(Cat cat) {
        return getBaseMapper().updateById(cat) > 0 ? true : false;
    }

    @Override
    public Cat selectById(Integer id) {
        return getBaseMapper().selectById(id);
    }
}
