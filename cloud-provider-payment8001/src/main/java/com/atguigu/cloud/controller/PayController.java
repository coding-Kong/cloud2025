package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kdz
 * @create 2025-03-22-21:19
 */

@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {


    @Resource
    private PayService payService;


    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水，json串作为参数")
    public ResultData<String> addPay(@RequestBody Pay pay){
        log.info("添加支付信息：{}",pay);
        int add = payService.add(pay);
        return ResultData.success("插入成功，返回值：" + add);
    }

    @DeleteMapping(value = "/pay/delete/{id}")
    @Operation(summary = "删除",description = "根据id删除支付流水")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){

        int delete = payService.delete(id);
        return ResultData.success(delete);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水，json串作为参数")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){

        log.info("修改支付信息：{}",payDTO);
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int update = payService.update(pay);
        return ResultData.success("更新成功，返回值：" + update);
    }


    @GetMapping(value = "/pay/getById/{id}")
    @Operation(summary = "查询",description = "根据id查询支付流水")
    public ResultData<Pay> getPayById(@PathVariable("id") Integer id){
        return ResultData.success(payService.getById(id));
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查询",description = "查询所有支付流水")
    public ResultData<List<Pay>> getPayById(){
        return ResultData.success(payService.getAll());
    }


    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/getInfoByConsul")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo) {
        return "atguiguInfo:" + atguiguInfo +"\n" + "serverPort:" + serverPort;
    }
}
