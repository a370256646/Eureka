package com.xp.eurekaconsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/ribbon-consume",method = RequestMethod.GET)
    public String HelloConsumer(){
        return restTemplate.getForEntity("http://HELLO_SERVICE/hello",String.class).getBody();
    }
}
