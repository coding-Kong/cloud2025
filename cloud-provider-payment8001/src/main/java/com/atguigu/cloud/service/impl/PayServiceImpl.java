package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kdz
 * @create 2025-03-22-20:55
 */

@Service
public class PayServiceImpl implements PayService {


    @Resource
    private PayMapper payMapper;
    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(Pay pay) {
        return 0;
    }

    @Override
    public Pay getById(Integer id) {
        return null;
    }

    @Override
    public List<Pay> getAll() {
        return null;
    }
}
