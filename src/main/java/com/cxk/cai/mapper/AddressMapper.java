package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.ShAddress;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface AddressMapper extends BaseMapper<Commodity> {

    /**
     * 查询用户所有的收货地址
     * @param uid 用户ID
     * @return
     */
    @Select("select * from cai.shaddress where uid = #{uid};")
    List<ShAddress> allAddress(Integer uid);

    /**
     * ShAddressMap 让数据库字段与实体对应
     * 添加用户收货地址
     * @param shAddress
     * @return
     */
    @Results(id = "ShAddressMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "detailAddress", column = "detail_address")
    })
    @Insert("insert into cai.shaddress(uid,name,phone,detail_address,address) values(#{uid},#{name},#{phone},#{detailAddress},#{address});")
    int insertAddress(ShAddress shAddress);

    @Select("select count(1) from cai.shaddress where uid = #{uid};")
    int numberAddress(Integer uid);

    @Delete("delete from cai.shaddress where id = #{id};")
    int delAddress(Integer id);

    int updateAddress(ShAddress shAddress);
}
