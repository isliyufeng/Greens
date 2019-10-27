package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Comment;

public interface CommentService extends IService<Comment> {
    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    boolean add(Comment comment);

    /**
     * 删除评论
     *
     * @param id
     * @return
     */
    boolean del(Integer id);
}
