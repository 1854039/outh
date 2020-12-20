package com.example.userservice.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @CrossOrigin
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    @ResponseBody
    public int Register(@RequestParam(value = "username") String userName, @RequestParam(value = "userpwd") String userPwd) throws ClassNotFoundException {

        int register=-1;
        String sqlquery = "SELECT user_ID FROM user WHERE user_name=" + '"' + userName + '"' + "AND user_pwd=" + '"' + userPwd + '"';
        try{
            register=jdbcTemplate.queryForObject(sqlquery,Integer.class);
        }catch (Exception e){register= -2;}

        //登录失败
        if (register==-2) {
            return -1;
        }
        return 0;
    }
}
