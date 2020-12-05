package example.controller;

import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.*;
import java.io.IOException;

@RestController
public class SearchService {
    @CrossOrigin
    @RequestMapping(path = "/shentong", method = RequestMethod.GET)
    @ResponseBody
    public void SearchShenTong(@RequestParam(value = "num") int packageID,@RequestParam(value = "cid") int companyID ) throws IOException {

        httpConnectionService conn=new httpConnectionService();
        String url="https://api.kdniao.com/?LogisticCode="+packageID+"?ShipperCode=SF";
        //调用connectionService方法访问第三方api
        String post= conn.connectService(url);
        JSONObject jsonObject = JSON.parseObject(post);
        System.out.println(jsonObject);
    }
}
