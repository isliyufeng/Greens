package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.entity.Commodity;
import com.cxk.cai.entity.Order;
import com.cxk.cai.entity.OrderEveryone;
import com.cxk.cai.mapper.CommodityMapper;
import com.cxk.cai.mapper.OrderEveryoneMapper;
import com.cxk.cai.mapper.OrderMapper;
import com.cxk.cai.service.OrderService;
import com.cxk.cai.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    OrderEveryoneMapper orderEveryoneMapper;

    @Override
    public boolean addOrder(Integer uid, Integer[] cid) {
        // 计算总价
        List<Integer> integers = Arrays.asList(cid);
        List<Commodity> commodities = commodityMapper.selectBatchIds(integers);
        float totle = 0;
        for (Commodity commodity : commodities) {
            totle += commodity.getOldprice();
        }
        // 添加订单
        Order order = new Order();
        order.setUid(uid);
        order.setTotalmoney(totle);
        order.setCreatetime(new Date());
        order.setStateid(1);
        order.setOrderid(UUIDUtils.getUUID());
        int i = orderMapper.addOrder(order);
        // 向OrderEveryone表添加数据，因为是一个订单对应多个商品
        for (Integer integer1 : integers) {
            OrderEveryone orderEveryone = new OrderEveryone();
            orderEveryone.setUid(uid);
            orderEveryone.setCid(integer1);
            orderEveryone.setOid(order.getId());
            int insert1 = orderEveryoneMapper.insert(orderEveryone);
            if (insert1 <= 0) {
                return false;
            }
        }
       if (i > 0) {
           return true;
       }
        return false;
    }

    @Override
    public boolean delOrder(Integer id) {
        int i = orderMapper.delById(id);
        if (i > 0) {
            int oid = orderEveryoneMapper.delete(new QueryWrapper<OrderEveryone>().eq("oid", id));
            System.out.println(oid);
            if (oid > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean payment(Integer id, Integer paytype, Integer sid) {
        return orderMapper.updateState(id, paytype, sid) > 0 ? true : false;
    }

    @Override
    public boolean receive(Integer id) {
        return orderMapper.updateReceive(id) > 0 ? true : false;
    }

    @Override
    public boolean send(Integer id) {
        return orderMapper.send(id) > 0 ? true : false;
    }

    @Override
    public boolean updateNoReceive(Integer id) {
        return orderMapper.updateNoReceive(id) > 0 ? true : false;
    }
}
