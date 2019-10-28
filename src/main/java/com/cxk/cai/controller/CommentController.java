package com.cxk.cai.controller;

import com.cxk.cai.entity.Comment;
import com.cxk.cai.entity.CommentVo;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@RequestMapping("/comment")
@RestController
@Api(value = "评论模块", tags = "评论模块的接口")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * 用户评论商品 commenttype传参 1, 并且传一个 cid， content， createtime
     * 商户评论用户，或者用户回复商户， 需要 commenttype 传参 0， 并且传一个 oneid， twoid， content, createtime
     *
     * @param comment
     * @return
     */
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

    @RequestMapping("/getCommentOne.do")
    @ApiOperation(value = "获取用户评论商品的评论(降序)", notes = "获取用户评论商品的评论， 用户评论商品传参1", httpMethod = "POST")
    public ResultVo getCommentOne() {
        List<Comment> list = commentService.getCommentOne(1);
        if (list != null) {
            return ResultVo.setSUCCESS(list);
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/getCommentTwo.do")
    @ApiOperation(value = "获取全部用户和商家的互相评论(升序)", notes = "获取全部用户和商家的互相评论", httpMethod = "POST")
    public ResultVo getCommentTwo(Integer cid) {
        List<Comment> list = commentService.getCommentTwo(0);
        if (list != null) {
            return ResultVo.setSUCCESS(list);
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/getComment.do")
    @ApiOperation(value = "获取商品评论和对话顺序调整好的List接口", notes = "获取商品评论和对话顺序调整好的List", httpMethod = "POST")
    public ResultVo getComment(Integer cid) {
        // 先获取到所有的用户给商品评论的数据，降序
        List<Comment> commentOne = commentService.getCommentOne(1);
        // 获取到所有的用户与商家的互相评论
        List<Comment> commentTwo = commentService.getCommentTwo(0);
        // 调整聊天位置，并放入list集合返回出去
        // 判断获取到的commentOne是否为空集合
        if (commentOne != null && !"".equals(commentOne)) {
            // 循环commentOne，开始插入数据
            List<CommentVo> list = new ArrayList<>();
            for (Comment comment : commentOne) {
                // 判断获取到的commentTwo是否为空集合
                if (comment.getCid() != null && !"".equals(comment.getCid())) {
                    // 开始查询对应商品的对应评论内容，升序
                    // 用于存储对话
                    List<Comment> commentTwos = new ArrayList<>();
                    CommentVo commentVo = new CommentVo();
                    for (Comment comment1 : commentTwo) {
                        // 判断如果对话中的comid等于评论商品中的评论数据的id，就将该条数据加入commentTwos这个list中
                        if (comment1.getComid().equals(comment.getId())) {
                            commentTwos.add(comment1);
                        }
                    }
                    // 将同一评论id和同一商品id的数据加入一个CommentVo对象中
                    commentVo.setComment(comment);
                    commentVo.setCommentIntoList(commentTwos);
                    list.add(commentVo);
                }
            }
            return ResultVo.setSUCCESS(list);
        }
        return ResultVo.setERROR();
    }

}
