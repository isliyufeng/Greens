package com.cxk.cai.entity;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public class CommentVo {
    private Comment comment;
    private List<Comment> commentIntoList;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Comment> getCommentIntoList() {
        return commentIntoList;
    }

    public void setCommentIntoList(List<Comment> commentIntoList) {
        this.commentIntoList = commentIntoList;
    }
}
