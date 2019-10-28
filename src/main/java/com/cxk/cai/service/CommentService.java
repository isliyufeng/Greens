package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Comment;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
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

    /**
     * 获取用户评论商品的方法， commenttype的值为1时，是用户给商品评论，值为0时，是用户与商家互相评论
     *
     * @param i
     * @return
     */
    List<Comment> getCommentOne(int i);

    /**
     * 获取用户回复商家，商家评论用户的方法， 要求commenttype值为0时！
     *
     * @param i
     * @return
     */
    List<Comment> getCommentTwo(int i);
}
