package com.atguigu.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author kdz
 * @create 2025-03-23-10:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO {

    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
