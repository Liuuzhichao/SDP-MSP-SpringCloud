package com.bcp.sdp.msp.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @packageName： com.bcp.sdp.msp.eureka
 * @className: EurekaApplication
 * @description: TODO
 * @version: v1.0
 * @author: liuzhichao
 * @date: 2020-04-20 14:48
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
        System.out.println("---------->start");
    }

    /**
     * @description: 使用 HTTP 方式进行服务间通信时,实现客户端的负载均衡
     * @param: []
     * @return: org.springframework.web.client.RestTemplate
     * @author: liuzhichao 2021-05-07 14:04
     */       
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        int id = 1001;
        restTemplate.delete("http://TEST/test/{1}", id);
    }

}
