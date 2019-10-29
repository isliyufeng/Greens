package com.cxk.cai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxk.cai.entity.Order;

/**
 * @author 喜闻乐见i
 */
public interface OrderService extends IService<Order> {
    /**
     * 添加订单
     *
     * @param uid
     * @param cid
     * @return
     */
    boolean addOrder(Integer uid, Integer[] cid);

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    boolean delOrder(Integer id);

    /**
     * 修改支付状态
     *
     * @param id
     * @param paytype 1 支付宝，2 微信， 3 其他方式
     * @param sid
     * @return
     */
    boolean payment(Integer id, Integer paytype, Integer sid);

    /**
     * 确认收货
     *
     * @param id
     * @return
     */
    boolean receive(Integer id);

    /**
     * 发货
     * @param id
     * @return
     */
    boolean send(Integer id);

    /**
     * 未收货
     * @param id
     * @return
     */
    boolean updateNoReceive(Integer id);
}
