package com.cxk.cai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxk.cai.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;


/**
 * @author 喜闻乐见i
 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * order 是关键字！！！！！
     *
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 根据id删除订单
     *
     * @param id
     * @return
     */
    int delById(Integer id);

    /**
     * 修改订单状态 2
     *
     * @param id
     * @param paytype
     * @param sid
     * @return
     */
    int updateState(Integer id, Integer paytype, Integer sid);

    /**
     * 确认收货 5
     *
     * @param id
     * @return
     */
    int updateReceive(Integer id);

    /**
     * 发货 3
     *
     * @param id
     * @return
     */
    int send(Integer id);

    /**
     * 未收货 4
     *
     * @param id
     * @return
     */
    int updateNoReceive(Integer id);
}
