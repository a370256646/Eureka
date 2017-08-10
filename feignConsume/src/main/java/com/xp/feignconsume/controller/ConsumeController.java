package com.xp.feignconsume.controller;

import com.xp.feignconsume.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {
    @Autowired
    IHelloService helloService;

    @RequestMapping(value = "feign-consume",method = RequestMethod.GET)
    public String HelloConsumer(){
        return helloService.hello();
    }
}
