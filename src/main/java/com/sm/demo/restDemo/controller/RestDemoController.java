package com.sm.demo.restDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Newbody on 2016/2/27.
 */
@RestController
public class RestDemoController {

    @RequestMapping("demo/rest/test1")
    public String test1(){
        return "rest demo";
    }

}
