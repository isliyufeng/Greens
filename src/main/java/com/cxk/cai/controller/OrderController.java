package com.cxk.cai.controller;

import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.CommodityService;
import com.cxk.cai.service.OrderService;
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
@RequestMapping("/order")
@CrossOrigin(value = "*", maxAge = 3600)
@Api(value = "订单模块", tags = "订单模块的接口")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CommodityService commodityService;

    @RequestMapping("/addOrder.do")
    @ApiOperation(value = "添加订单", notes = "添加订单的接口", httpMethod = "POST")
    public ResultVo addOrder(Integer uid, Integer[] cid) {
        if (!"".equals(uid) && uid != null) {
            boolean result = orderService.addOrder(uid, cid);
            boolean in = commodityService.updateInventory(cid);
            if (result && in) {
                return ResultVo.setSUCCESS("OK");
            }
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/delOrder.do")
    @ApiOperation(value = "删除订单", notes = "删除订单的接口", httpMethod = "POST")
    public ResultVo delOrder(Integer id) {
        if (!"".equals(id) && id != null) {
            boolean result = orderService.delOrder(id);
            if (result) {
                return ResultVo.setSUCCESS("OK");
            }
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/payment.do")
    @ApiOperation(value = "支付 未发货", notes = "支付 未发货的接口", httpMethod = "POST")
    public ResultVo payment(Integer id, Integer paytype, Integer sid) {
        if (!"".equals(id) && id != null) {
            boolean result = orderService.payment(id, paytype, sid);
            if (result) {
                return ResultVo.setSUCCESS("OK");
            }
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/send.do")
    @ApiOperation(value = "已发货", notes = "已发货的接口", httpMethod = "POST")
    public ResultVo send(Integer id) {
        if (!"".equals(id) && id != null) {
            boolean result = orderService.send(id);
            if (result) {
                return ResultVo.setSUCCESS("OK");
            }
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/noReceive.do")
    @ApiOperation(value = "未收货", notes = "未收货的接口", httpMethod = "POST")
    public ResultVo noReceive(Integer id) {
        if (!"".equals(id) && id != null) {
            boolean result = orderService.updateNoReceive(id);
            if (result) {
                return ResultVo.setSUCCESS("OK");
            }
        }
        return ResultVo.setERROR();
    }

    @RequestMapping("/receive.do")
    @ApiOperation(value = "确认收货", notes = "确认收货的接口", httpMethod = "POST")
    public ResultVo receive(Integer id) {
        if (!"".equals(id) && id != null) {
            boolean result = orderService.receive(id);
            if (result) {
                return ResultVo.setSUCCESS("OK");
            }
        }
        return ResultVo.setERROR();
    }
}
