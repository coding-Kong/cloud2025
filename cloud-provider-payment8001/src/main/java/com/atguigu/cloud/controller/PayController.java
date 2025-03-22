package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kdz
 * @create 2025-03-22-21:19
 */

@RestController
@Slf4j
public class PayController {


    @Resource
    private PayService payService;


    @PostMapping(value = "/pay/add")
    public String addPay(@RequestBody Pay pay){
        log.info("添加支付信息：{}",pay);
        int add = payService.add(pay);
        return "插入成功，返回值：" + add;
    }

    @DeleteMapping(value = "/pay/delete/{id}")
    public Integer deletePay(@PathVariable("id") Integer id){
        return payService.delete(id);
    }

    @PutMapping(value = "/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO){

        log.info("修改支付信息：{}",payDTO);
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int update = payService.update(pay);
        return "更新成功，返回值：" + update;
    }


    @GetMapping(value = "/pay/getById/{id}")
    public Pay getPayById(@PathVariable("id") Integer id){
        return  payService.getById(id);
    }

    @GetMapping(value = "/pay/getAll")
    public List<Pay> getPayById(){
        return  payService.getAll();
    }

}
