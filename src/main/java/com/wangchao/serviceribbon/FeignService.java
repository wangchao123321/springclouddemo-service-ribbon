package com.wangchao.serviceribbon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-HELLOWORLD", fallback = FeignServiceFailure.class)
@Service
public interface FeignService {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello();

}

class FeignServiceFailure implements FeignService {

    @Override
    public String sayHello() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available !";
    }
}