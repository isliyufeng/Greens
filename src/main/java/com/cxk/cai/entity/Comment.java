package com.cxk.cai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 喜闻乐见i
 */
@TableName("comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer oneid;
    private Integer twoid;
    private Integer commenttype;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOneid() {
        return oneid;
    }

    public void setOneid(Integer oneid) {
        this.oneid = oneid;
    }

    public Integer getTwoid() {
        return twoid;
    }

    public void setTwoid(Integer twoid) {
        this.twoid = twoid;
    }

    public Integer getCommenttype() {
        return commenttype;
    }

    public void setCommenttype(Integer commenttype) {
        this.commenttype = commenttype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
