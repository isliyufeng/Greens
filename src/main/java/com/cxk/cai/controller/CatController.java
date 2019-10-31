package com.cxk.cai.controller;

import com.cxk.cai.entity.Cat;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.CatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 喜闻乐见i
 */
@RestController
@RequestMapping("/cat")
@CrossOrigin(value = "*", maxAge = 3600)
@Api(value = "购物车模块", tags = "购物车模块的接口")
public class CatController {
    @Autowired
    CatService catService;

    @RequestMapping("/add.do")
    @ApiOperation(value = "添加购物车", notes = "添加购物车的接口", httpMethod = "POST")
    public ResultVo addCommodityToCat(Integer cid, Float price, Integer number, Integer uid) {
        Cat cat = new Cat();
        cat.setCid(cid);
        cat.setNumber(number);
        cat.setPrice(number * price);
        cat.setUid(uid);
        return catService.add(cat) ? ResultVo.setSUCCESS("OK") : ResultVo.setERROR();
    }

    @RequestMapping("/del.do")
    @ApiOperation(value = "删除购物车中的商品", notes = "删除购物车的商品的接口", httpMethod = "POST")
    public ResultVo delCommodityById(Integer id) {
        return catService.del(id) ? ResultVo.setSUCCESS("OK") : ResultVo.setERROR();
    }

    @RequestMapping("/selectAll.do")
    @ApiOperation(value = "查询购物车中所有的商品", notes = "查询购物车中所有的商品的接口", httpMethod = "POST")
    public ResultVo selectAll(Integer id) {
        return ResultVo.setSUCCESS(catService.selectAll(id));
    }

    @RequestMapping("/updateByNumber.do")
    @ApiOperation(value = "修改购物车中商品的数量", notes = "修改购物车中商品的数量的接口", httpMethod = "POST")
    public ResultVo updateByNumber(Integer id, Integer number) {
        Cat cat1 = catService.selectById(id);
        Cat cat = new Cat();
        cat.setId(id);
        cat.setPrice(cat1.getPrice() / cat1.getNumber() * number);
        cat.setNumber(number);
        boolean result = catService.updateByNumber(cat);
        if (result) {
            return ResultVo.setSUCCESS(catService.selectById(id));
        } else {
            return ResultVo.setERROR();
        }
    }
}
