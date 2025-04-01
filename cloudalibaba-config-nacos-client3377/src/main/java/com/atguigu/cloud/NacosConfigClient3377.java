package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kdz
 * @create 2025-04-01-22:18
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377.class,args);
    }
}
