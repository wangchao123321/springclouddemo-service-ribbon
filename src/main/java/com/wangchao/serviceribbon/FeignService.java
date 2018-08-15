package com.wangchao.serviceribbon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-HELLOWORLD")
public interface FeignService {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String sayHello();

}
