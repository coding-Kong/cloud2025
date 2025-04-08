package com.atguigu.cloud.service;

/**
 * @author kdz
 * @create 2025-04-08-22:19
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
