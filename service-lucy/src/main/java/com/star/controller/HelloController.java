package com.star.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hiError")
    public String index(@RequestParam(value = "name", required = false) String name) {
        StringBuffer uriList = new StringBuffer("Hello " + name + "----" + port + " 端口为您服务！<br>");
        return uriList.toString();
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
