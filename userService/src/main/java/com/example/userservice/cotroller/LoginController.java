package com.example.userservice.cotroller;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping(path = "/name", method = RequestMethod.GET)
    @ResponseBody
    public int Login(@RequestParam(value = "username") String userName, @RequestParam(value = "userpwd") String userPwd) throws ClassNotFoundException, PropertyVetoException, SQLException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //在user表中检索是否有username
        int userid = -1;
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        String connectionUrl = "jdbc:mysql://rm-bp115mpt4e06jd56y125010im.mysql.rds.aliyuncs.com/login-register";
        ResultSet resultSet;
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl(connectionUrl);
        dataSource.setUser("web_soa");
        dataSource.setPassword("Web_soa123");

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        String sqlquery = "SELECT * FROM user WHERE user_name=";
        //输入希望执行的SQL。
        resultSet = statement.executeQuery(sqlquery + '"' + userName + '"');

        /*List<Map<String, Object>> name = */
        if (resultSet != null) { /*  //有，返回-1
        if (name != null) {*/
            return -1;
        }

        //没有，把username和userpwd加入数据库中，并分配一个userid
        else {
            //准备sql语句
            String sql1 = "SELECT MAX(user_ID) FROM user";
            int maxid = jdbcTemplate.queryForObject(sql1, Integer.class);
            System.out.println(maxid);
            String sql = "INSERT INTO user VALUES(" + '"' + (maxid + 1) + '"' + "," + '"' + userName + '"' + "," + '"' + userPwd + '"' + ")";
            //执行sql语句
            jdbcTemplate.execute(sql);
            return 0;
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    @ResponseBody
    public int Loginn(@RequestParam(value = "username") String userName, @RequestParam(value = "userpwd") String userPwd) throws ClassNotFoundException, PropertyVetoException, SQLException {

        if (userName == "hc")
            return -1;
        else if (userName == "hcc" && userPwd == "1234")
            return 1;
return  0;
    }
}


