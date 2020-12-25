package com.example.expressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExpressserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpressserviceApplication.class, args);
    }

}
