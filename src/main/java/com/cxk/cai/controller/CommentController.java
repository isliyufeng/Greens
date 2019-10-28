package com.cxk.cai.controller;

import com.cxk.cai.entity.Comment;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 喜闻乐见i
 */
@RequestMapping("/comment")
@RestController
@Api(value = "评论模块", tags = "评论模块的接口")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/add.do")
    @ApiOperation(value = "发表评论", notes = "可以进行商品评论，也可以用于户店家回复用户的评论", httpMethod = "POST")
    public ResultVo comment(Comment comment) {
        if (comment.getOneid() != null && !"".equals(comment.getOneid()) && comment.getTwoid() != null
                && !"".equals(comment.getTwoid()) && comment.getContent() != null && !"".equals(comment.getContent())
                && comment.getCommenttype() != null && !"".equals(comment.getCommenttype())) {
            return commentService.add(comment) ? ResultVo.setSUCCESS("OK") : ResultVo.setERROR();
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/del.do")
    @ApiOperation(value = "删除评论", notes = "可以删除自己的评论，也可以用于户店家删除自己的评论", httpMethod = "GET")
    public ResultVo comment(Integer id) {
        if (!"".equals(id) && id != null) {
            return commentService.del(id) ? ResultVo.setSUCCESS("OK") : ResultVo.setERROR();
        }
        return ResultVo.setERROR();
    }
}
