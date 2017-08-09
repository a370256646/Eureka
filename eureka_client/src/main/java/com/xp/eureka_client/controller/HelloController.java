package com.xp.eureka_client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String hello(){
        ServiceInstance instance=client.getLocalServiceInstance();
        return "hello world!host is :"+instance.getHost()+",serviceId is :"+instance.getServiceId();
    }
}
