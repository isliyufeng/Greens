package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Comment;
import com.cxk.cai.mapper.CommentMapper;
import com.cxk.cai.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override
    public boolean add(Comment comment) {
        return getBaseMapper().insert(comment) > 0 ? true : false;
    }

    @Override
    public boolean del(Integer id) {
        return getBaseMapper().deleteById(id) > 0 ? true : false;
    }
}
