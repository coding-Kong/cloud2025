package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kdz
 * @create 2025-04-01-22:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main83 {

    public static void main(String[] args) {
        SpringApplication.run(Main83.class,args);
    }
}
