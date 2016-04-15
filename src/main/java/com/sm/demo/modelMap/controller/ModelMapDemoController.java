package com.sm.demo.modelMap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Newbody on 2016/2/27.
 */

@Controller
public class ModelMapDemoController {

    @RequestMapping("demo/modelMap/test1")
    public String test1(@RequestParam(value = "param2", required = false) String param2, ModelMap modelMap){
        modelMap.put("param1", "test1");
        System.out.println(param2);
        return "demo/modelMap/modelMapTest1";
    }

}
