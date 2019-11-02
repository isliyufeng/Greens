package com.cxk.cai.controller;

import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.CommodityVo;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@RestController
@Api(value = "商品模块", tags = "商品模块的接口")
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @RequestMapping("/getNewCommodity.do")
    @ApiOperation(value = "新品上市", notes = "新品上市接口", httpMethod = "POST")
    public ResultVo getNewCommodity(Integer num) {
        List<Commodity> list = commodityService.getNewCommodity(num);
        return ResultVo.setSUCCESS(list);
    }

    @RequestMapping("/getCommodityByTypeId.do")
    @ApiOperation(value = "获取商品", notes = "根据商品分类id获取商品接口", httpMethod = "POST")
    public ResultVo getCommodity(Integer id, Integer num) {
        List<Commodity> list = commodityService.getCommodity(id, num);
        return ResultVo.setSUCCESS(list);
    }

    @RequestMapping("/getCommodityInfoById.do")
    @ApiOperation(value = "获取商品详细信息", notes = "根据商品id获取商品详细信息接口", httpMethod = "POST")
    public ResultVo getCommodityInfoById(Integer id) {
        return ResultVo.setSUCCESS(commodityService.getCommodityInfoById(id));
    }

    @RequestMapping("/selectCommodityByName.do")
    @ApiOperation(value = "查询商品详细信息", notes = "根据商品关键字获取商品接口", httpMethod = "POST")
    public ResultVo selectCommodityByName(String name) {
        List<Commodity> commodities = commodityService.selectCommodityByName(name);
        return ResultVo.setSUCCESS(commodities);
    }

    @RequestMapping("/getCommodity.do")
    @ApiOperation(value = "获取指定商品的库存", notes = "获取指定商品的库存的接口", httpMethod = "POST")
    public ResultVo getCommodity(Integer id) {
        CommodityVo commodityVo = commodityService.selectCommodityInventoryById(id);
        Commodity byId = commodityService.getById(id);
        commodityVo.setCommodity(byId);
        return ResultVo.setSUCCESS(commodityVo);
    }
}
