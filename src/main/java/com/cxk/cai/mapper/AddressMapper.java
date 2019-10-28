package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ShAddress;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface AddressMapper extends BaseMapper<Commodity> {

    //查询用户所有的收货地址
    @Select("select * from cai.shaddress where uid = #{uid};")
    List<ShAddress> allAddress(Integer uid);
}
