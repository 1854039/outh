package com.example.eurekaclient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class eurekaclientApplication {
    public static void main(String[] args) {
        SpringApplication.run(eurekaclientApplication.class, args);
    }
}