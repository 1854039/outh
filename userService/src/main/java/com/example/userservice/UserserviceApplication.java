package com.example.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootApplication()
@EnableDiscoveryClient
public class UserserviceApplication{
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
