package com.wangchao.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {


    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return feignService.sayHello();
    }

}
