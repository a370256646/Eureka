package com.xp.feignconsume.controller;

import com.xp.feignconsume.model.User;
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


    @RequestMapping(value = "feign-consume-param",method = RequestMethod.GET)
    public String HelloWithParamConsumer(){
        return helloService.hello("xp");
    }

    @RequestMapping(value = "feign-consume-header-param",method = RequestMethod.GET)
    public String HelloWithHeaderParamConsumer(){
        return helloService.hello("xp",24);
    }

    @RequestMapping(value = "feign-consume-body-param",method = RequestMethod.GET)
    public String HelloWithBodyParamConsumer(){
        return helloService.hello(new User("xp",24));
    }
}
