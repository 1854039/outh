package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/test")
    @ResponseBody
    public int Login(@RequestParam(value = "username") String userName, @RequestParam(value = "userpwd") String userPwd) throws ClassNotFoundException {

        int login = -1;
        String sqlquery = "SELECT user_ID FROM user WHERE user_name=" + '"' + userName + '"' + "AND user_pwd=" + '"' + userPwd + '"';
        try {
            login = jdbcTemplate.queryForObject(sqlquery, Integer.class);
        } catch (Exception e) {
            login = -2;
        }

        //登录失败
        if (login == -2) {
            return -1;
        }
        return 0;
    }
}
