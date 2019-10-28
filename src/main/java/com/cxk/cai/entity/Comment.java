package com.cxk.cai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用户评论商品 commenttype传参 1, 并且传一个 cid， content， createtime
 * 商户评论用户，或者用户回复商户， 需要 commenttype 传参 0， 并且传一个 oneid， twoid， content, createtime, comid
 * comid指的是用户评论商品的那条数据的id
 * createtime，创建这条评论的时间
 * content，评论的内容
 * oneid, twoid, 指的是谁给谁评论，如果用户给商品评论则只传一个oneid就成，这个oneid在此处是只用户的id
 * cid指得是商品的id
 * commenttype为1，指的是用户评论商品，为0，指的是用户和商家的互相评论
 *
 *
 * @author 喜闻乐见i
 */
@TableName("comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer cid;
    private Integer oneid;
    private Integer twoid;
    private Integer commenttype;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;
    private Integer comid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }
}
