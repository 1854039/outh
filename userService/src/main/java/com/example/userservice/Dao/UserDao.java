package com.example.userservice.Dao;

import com.example.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

//    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public UserDao()
//    {
//        this.setJdbcTemplate(jdbcTemplate);
//    }
//    //查询数据,使用RowCallbackHandler处理结果集
//    public  String getUser(String userName)
//    {final User user=new User();
//        String sqlquery = "SELECT * FROM user WHERE user_name="+userName;
//        //输入希望执行的SQL。
//        String result= jdbcTemplate.queryForObject(sqlquery,String.class,userName);
//        return result;
//    }
//


}
