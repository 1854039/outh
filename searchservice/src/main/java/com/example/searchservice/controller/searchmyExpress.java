package com.example.searchservice.controller;

import org.springframework.web.bind.annotation.*;
@RestController
public class searchmyExpress {

    @CrossOrigin
    @RequestMapping(path = "/searchmy", method = RequestMethod.GET)
    @ResponseBody
    public void SearchShenTong(@RequestParam(value = "num") String packageID, @RequestParam(value = "cid") String companyID )
    {

    }
}

