package com.wangchao.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloService {

    @Autowired
    private HelloService2 helloService2;

    @RequestMapping("/")
    @ResponseBody
    public String getHelloContent() {
        String forObject = helloService2.getHelloContent();
        System.out.println(forObject);
        return forObject;
    }
}

@Service
class HelloService2 {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getHelloContent() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);
    }

    public String serviceFailure() {
        return "hello world service is not available !";
    }
}
