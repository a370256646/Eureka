package com.xp.eureka_client.controller;


import com.xp.eureka_client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String hello(){
        ServiceInstance instance=client.getLocalServiceInstance();
        return "hello world!host is :"+instance.getHost()+",serviceId is :"+instance.getServiceId();
    }


    //方法扩展,学习feign参数绑定
    @RequestMapping(value = "/hello-param",method = RequestMethod.GET)
    public String helloWithParam(@RequestParam String name){
        return "this is param method,hello "+name;
    }

    @RequestMapping(value = "/hello-headerParam",method = RequestMethod.GET)
    public String helloWithHeadParam(@RequestHeader String name){
        return "this is header param method,hello "+name;
    }

    @RequestMapping(value = "/hello-bodyParam",method = RequestMethod.POST)
    public String helloWithBody(@RequestBody User user){
        return "hello,"+user.getName()+","+user.getAge();
    }


}
