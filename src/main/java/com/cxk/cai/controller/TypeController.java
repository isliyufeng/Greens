package com.cxk.cai.controller;

import com.cxk.cai.entity.OneType;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.Types;
import com.cxk.cai.service.OneTypeService;
import com.cxk.cai.service.TwoTypeService;
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
@RestController
@RequestMapping("/type")
@Api(value = "分类", tags = "一级分类、二级分类的接口")
public class TypeController {
    @Autowired
    OneTypeService oneTypeService;

    @Autowired
    TwoTypeService twoTypeService;

    List<Types> list = new ArrayList<>();

    @ApiOperation(value = "获取分类", notes = "获取分类接口", httpMethod = "POST")
    @RequestMapping("/getType.do")
    public ResultVo getType() {
        List<OneType> oneTypes = oneTypeService.getOneType();
        System.out.println("11111" + oneTypes.toString());
        if (!oneTypes.equals("") && oneTypes != null) {
            for (OneType oneType : oneTypes) {
                Types type = new Types();
                type.setOneType(oneType);
                type.setTwoType(twoTypeService.getTwoTypeByOneId(oneType.getId()));
                list.add(type);
            }
            return ResultVo.setSUCCESS(list);
        }
        return ResultVo.setERROR();
    }
}
