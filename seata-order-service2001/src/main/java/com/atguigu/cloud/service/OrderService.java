package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @author kdz
 * @create 2025-04-08-21:43
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
