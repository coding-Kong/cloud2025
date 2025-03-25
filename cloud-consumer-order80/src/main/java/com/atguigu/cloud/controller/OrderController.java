package com.atguigu.cloud.controller;

import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author kdz
 * @create 2025-03-23-10:13
 */

@RestController
public class OrderController {

//    public static final String PaymentSrv_URL = "http://localhost:8001";
    public static final String PaymentSrv_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/delete/{id}")
    public void deletePayById(@PathVariable("id") Integer id){
         restTemplate.delete(PaymentSrv_URL+"/pay/delete/"+id);
    }

    @GetMapping(value = "/consumer/pay/update")
    public void updateOrder(PayDTO payDTO){
        restTemplate.put(PaymentSrv_URL+"/pay/update",payDTO);
    }


    @GetMapping(value = "/consumer/pay/getById/{id}")
    public ResultData getPayById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/getById/"+id,ResultData.class,id);
    }

    @GetMapping(value = "/consumer/pay/getAll")
    public ResultData getAllPay(){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/getAll",ResultData.class);
    }

    @GetMapping(value = "/consumer/getInfoByConsul")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/getInfoByConsul", String.class);
    }
}
