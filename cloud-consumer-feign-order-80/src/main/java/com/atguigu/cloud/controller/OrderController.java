package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author kdz
 * @create 2025-03-23-10:13
 */

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;


    @PostMapping(value = "/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        ResultData stringResultData = payFeignApi.addPay(payDTO);
        return stringResultData;
    }


    @GetMapping(value = "/feign/pay/getById/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        ResultData payById = payFeignApi.getPayById(id);
        return payById;
    }

    @GetMapping(value = "/feign/getInfoByConsul")
    public String mylb() {
        return payFeignApi.getInfoByConsul();
    }
}




