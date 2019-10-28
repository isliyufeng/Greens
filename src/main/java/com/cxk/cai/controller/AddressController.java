package com.cxk.cai.controller;

import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.ShAddress;
import com.cxk.cai.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "地址模块", tags = "收货地址模块的接口")
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("/allAddress")
    @ApiOperation(value = "查询用户收货地址", notes = "查询用户收货地址接口", httpMethod = "POST")
    public ResultVo allAddress(Integer uid) {
         return addressService.allAddress(uid);
    }

    @RequestMapping("/insertAddress")
    @ApiOperation(value = "添加用户收货地址", notes = "添加用户收货地址接口", httpMethod = "POST")
    public ResultVo insertAddress(ShAddress shAddress) {
        return addressService.insertAddress(shAddress);
    }
}
