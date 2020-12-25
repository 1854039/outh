package com.example.userservice.cotroller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class LoginController {
    @Autowired

   private JdbcTemplate jdbcTemplate;

    @CrossOrigin
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
