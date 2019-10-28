package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Order;
import com.cxk.cai.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface UserMapper extends BaseMapper<User> {
    List<Order> userOrder(Integer uid);

    @Select("select count(1) from cai.user where phone = #{phone} and password = #{password};")
    int IsPasswordTrue(User user);
}
