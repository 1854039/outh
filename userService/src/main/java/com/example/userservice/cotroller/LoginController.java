package com.example.userservice.cotroller;
<<<<<<< HEAD
import com.example.userservice.Dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
=======

>>>>>>> 9850ec86ac1b0509e0c9cecd616e7c8bf771045c
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.beans.PropertyVetoException;
import java.sql.*;
=======
>>>>>>> 9850ec86ac1b0509e0c9cecd616e7c8bf771045c

@RestController
@EnableSwagger2
public class LoginController {
    @Autowired
<<<<<<< HEAD
   private JdbcTemplate jdbcTemplate;

=======
    private JdbcTemplate jdbcTemplate;
>>>>>>> 9850ec86ac1b0509e0c9cecd616e7c8bf771045c

    @CrossOrigin
    @ApiOperation(value = "用户登录",tags = {"用户管理"})
   // @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "用户名", paramType = "body",required=true), @ApiImplicitParam(name = "userpwd", value = "密码", paramType = "body",required=true) })
    @RequestMapping(path = "/register", method = RequestMethod.GET)
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
