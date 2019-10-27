package com.cxk.cai.controller;

import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@RestController
@Api(value = "商品模块", tags = "商品模块的接口")
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @RequestMapping("/getNewCommodity")
    @ApiOperation(value = "新品上市", notes = "新品上市接口", httpMethod = "POST")
    public ResultVo getNewCommodity(Integer num) {
        List<Commodity> list = commodityService.getNewCommodity(num);
        return ResultVo.setSUCCESS(list);
    }
}