package com.cxk.cai.controller;

import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/collect")
@RestController
@Api(value = "收藏模块", tags = "收藏模块的接口")
public class CollectController {

    @Autowired
    CollectService collectService;

    @RequestMapping("/SelectUserCollect.do")
    @ApiOperation(value = "查询用户收藏商品", notes = "查询用户收藏商品接口", httpMethod = "POST")
    public ResultVo SelectUserCollect(Integer uid) {
        return collectService.SelectUserCollect(uid);
    }

    @RequestMapping("/userCollect.do")
    @ApiOperation(value = "用户收藏商品", notes = "用户收藏商品接口", httpMethod = "POST")
    public ResultVo userCollect(Integer uid, Integer cid) {
        return collectService.userCollect(uid, cid);
    }

    @RequestMapping("/delUserCollect.do")
    @ApiOperation(value = "取消用户收藏", notes = "取消用户收藏商品接口", httpMethod = "POST")
    public ResultVo delUserCollect(Integer uid, Integer cid) {
        return collectService.delUserCollect(uid, cid);
    }
}
