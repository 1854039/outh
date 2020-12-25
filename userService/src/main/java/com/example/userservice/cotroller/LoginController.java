package com.example.userservice.cotroller;
import com.example.userservice.Dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.beans.PropertyVetoException;
import java.sql.*;

@RestController
@EnableSwagger2
public class LoginController {
    @Autowired
   private JdbcTemplate jdbcTemplate;


    @CrossOrigin
    @ApiOperation(value = "用户登录",tags = {"用户管理"})
   // @ApiImplicitParams({ @ApiImplicitParam(name = "username", value = "用户名", paramType = "body",required=true), @ApiImplicitParam(name = "userpwd", value = "密码", paramType = "body",required=true) })
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    @ResponseBody
    public int Login(@RequestParam(value = "username") String userName, @RequestParam(value = "userpwd") String userPwd) throws ClassNotFoundException, PropertyVetoException, SQLException {


        UserDao userDao=new UserDao();
        String sqlquery = "SELECT user_name FROM user WHERE user_name="+'"'+userName+'"';
        //输入希望执行的SQL。
        String result="";
       try{ result= jdbcTemplate.queryForObject(sqlquery,String.class);}catch (Exception e){result=null;}
        if (result != null) { /*  //有，返回-1
        if (name != null) {*/
            return -1;
        }

        //没有，把username和userpwd加入数据库中，并分配一个userid
        else {
            //准备sql语句
            String sql1 = "SELECT MAX(user_ID) FROM user";
            int maxid = jdbcTemplate.queryForObject(sql1, Integer.class);
            System.out.println(maxid);
            String sql = "INSERT INTO user VALUES(" + '"' + userName + '"' + "," + '"' + userPwd + '"' + "," + '"' + (maxid + 1) + '"'+ ","  + '"' + 0 + '"' + ","+ '"' + 0 + '"' +  ")";
            //执行sql语句
            jdbcTemplate.update(sql);

            return 0;
        }
    }

}


