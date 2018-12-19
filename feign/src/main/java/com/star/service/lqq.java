package com.star.service;
import org.springframework.stereotype.Component;

@Component
public class lqq implements FeignService {

    @Override
    public String hello(String name) {
        return name+" sorry error";
    }
}
