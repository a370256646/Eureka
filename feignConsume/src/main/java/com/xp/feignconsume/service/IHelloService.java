package com.xp.feignconsume.service;

import com.xp.feignconsume.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("hello-service")
public interface IHelloService {

    @RequestMapping("/hello")
    String hello();

    //feign绑定参数示例,不要求方法名和接口提供的方法名称一致
    @RequestMapping(value="/hello-param",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello-headerParam",method = RequestMethod.GET)
    String hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello-bodyParam",method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
