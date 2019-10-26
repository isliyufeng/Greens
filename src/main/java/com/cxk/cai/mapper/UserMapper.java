package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Order;
import com.cxk.cai.entity.User;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface UserMapper extends BaseMapper<User> {
    List<Order> userOrder(Integer uid);
}
