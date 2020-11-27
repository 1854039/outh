package controller;

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

@RestController
@RequestMapping(value = "Login") // 注意这里不要在signin前后加"/"
public class LoginController {

    JdbcTemplate jdbcTemplate;

    @CrossOrigin(origins = {"*", "http://localhost:8082"})
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public int Login(@RequestParam(value = "username") String userName, @RequestParam(value = "userpwd") String userPwd) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //在user表中检索是否有username
        int userid=-1;
        String sqlquery = "SELECT * FROM user WHERE user_name=";
        List<Map<String, Object>> name = jdbcTemplate.queryForList(sqlquery + userName);
        //有，返回-1
        if (name != null) {
            return -1;
        }

        //没有，把username和userpwd加入数据库中，并分配一个userid
        else {
            //准备sql语句
            String sql1="SELECT MAX(user_ID) FROM user";
            int maxid=jdbcTemplate.queryForObject(sql1,Integer.class);
            System.out.println(maxid);
            String sql = "INSERT INTO user VALUES("+(maxid+1)+","+userName+","+userPwd+")";
            //执行sql语句
            jdbcTemplate.execute(sql);
            return 0;
        }
    }
}