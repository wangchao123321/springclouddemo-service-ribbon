package com.wangchao.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    @ResponseBody
    public String getHelloContent(){
        String forObject = restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);
        System.out.println(forObject);
        return forObject;
    }
}
