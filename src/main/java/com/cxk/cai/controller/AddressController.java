package com.cxk.cai.controller;

import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.ShAddress;
import com.cxk.cai.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "地址模块", tags = "收货地址模块的接口")
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("/allAddress.do")
    @ApiOperation(value = "查询用户收货地址", notes = "查询用户收货地址接口", httpMethod = "POST")
    public ResultVo allAddress(Integer uid) {
         return addressService.allAddress(uid);
    }

    @RequestMapping("/insertAddress.do")
    @ApiOperation(value = "添加用户收货地址", notes = "添加用户收货地址接口", httpMethod = "POST")
    public ResultVo insertAddress(ShAddress shAddress) {
        return addressService.insertAddress(shAddress);
    }

    @RequestMapping("/numberAddress.do")
    @ApiOperation(value = "查询用户收货地址个数", notes = "查询用户收货地址个数接口", httpMethod = "POST")
    public ResultVo numberAddress(Integer uid) {
        return addressService.numberAddress(uid);
    }

    @RequestMapping("/delAddress.do")
    @ApiOperation(value = "删除用户收货地址", notes = "删除用户收货地址接口", httpMethod = "POST")
    public ResultVo delAddress(Integer id) {
        return addressService.delAddress(id);
    }
}
