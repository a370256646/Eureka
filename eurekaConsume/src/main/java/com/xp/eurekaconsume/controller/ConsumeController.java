package com.xp.eurekaconsume.controller;


import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class ConsumeController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/ribbon-consume",method = RequestMethod.GET)
    public String HelloConsumer(){
        return restTemplate.getForEntity("http://HELLO_SERVICE/hello",String.class).getBody();
    }
}
