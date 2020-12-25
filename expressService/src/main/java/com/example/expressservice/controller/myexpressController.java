package com.example.expressservice.controller;

import com.example.expressservice.entity.R;
import com.example.expressservice.entity.expressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class myexpressController  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/myexpress")
    @ResponseBody
    public expressEntity MyExpress(@RequestParam(value = "userid") int userId){

//        String sqlquery = "SELECT * FROM express WHERE userID =" + '"' + userId + '"';
        String sqlquery = "SELECT * FROM express WHERE userID = ?";
        expressEntity express = new expressEntity();

        class expressEntityRowMapper implements RowMapper<expressEntity> {

            @Override
            public expressEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                expressEntity expressentity = new expressEntity();
                expressentity.setExpressid(rs.getInt("expressID"));
                expressentity.setUserid(rs.getInt("userID"));
                return expressentity;
            }

        }

        try {
            express = jdbcTemplate.queryForObject(sqlquery, new expressEntityRowMapper(), userId);
        } catch (Exception e){
            express.setUserid(-1);
            express.setExpressid(-1);
        }

        if (express.getExpressid()==-1){
            return express;
        }
        return express;
    }

    @CrossOrigin
    @RequestMapping("/expresslist")
    @ResponseBody
    public List<expressEntity> AllMyExpress(@RequestParam(value = "userid") int userId){

        String sqlquery = "SELECT * FROM express WHERE userID = ?";
        List<expressEntity> express = null;

        class expressEntityRowMapper implements RowMapper<expressEntity> {

            @Override
            public expressEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                expressEntity expressentity = new expressEntity();
                expressentity.setExpressid(rs.getInt("expressID"));
                expressentity.setUserid(rs.getInt("userID"));
                return expressentity;
            }

        }

        try {
            express = jdbcTemplate.query(sqlquery,new expressEntityRowMapper(),userId);
        } catch (Exception e){
            express.get(0).setUserid(-1);
            express.get(0).setExpressid(-1);
        }

        if (express.get(0).getExpressid()==-1){
            return express;
        }
        return express;

    }

    @CrossOrigin
    @RequestMapping("/test")
    @ResponseBody
    public R text(@RequestParam(value = "userid") int userId){

        String sqlquery = "SELECT * FROM express WHERE userID = ?";
        List<expressEntity> express = null;

        class expressEntityRowMapper implements RowMapper<expressEntity> {

            @Override
            public expressEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                expressEntity expressentity = new expressEntity();
                expressentity.setExpressid(rs.getInt("expressID"));
                expressentity.setUserid(rs.getInt("userID"));
                return expressentity;
            }

        }

        express = jdbcTemplate.query(sqlquery,new expressEntityRowMapper(),userId);
        return R.ok().data("items",express);
    }
}

