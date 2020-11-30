package com.example.userservice.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class RegisterController {
    JdbcTemplate jdbcTemplate;

    @CrossOrigin(origins = {"*", "http://localhost:8082"})
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public int Login(@RequestParam(value = "username") String userName, @RequestParam(value = "userpwd") String userPwd) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //在user表中检索是否有username
        int userid = -1;
        String sqlquery = "SELECT * FROM user WHERE user_name=" + "'" + userName + "'" + "AND user_pwd=" + "'"+ userPwd + "'";
        List<Map<String, Object>> name = jdbcTemplate.queryForList(sqlquery);
        //有，返回-1
        if (name != null) {
            return -1;
        }
        return 0;
    }
}
