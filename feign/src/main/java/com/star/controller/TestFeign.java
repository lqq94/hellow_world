package com.star.controller;
import com.star.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/feign")
public class TestFeign {


    @Autowired
    private  FeignService feignService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String helloConsumer(@RequestParam(value = "name" ,required = false) String name){
        return feignService.hello(name);
    }

}
