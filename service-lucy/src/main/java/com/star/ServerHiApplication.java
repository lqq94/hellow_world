package com.star;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.star.*"})
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceLucyApplication {
    /**
     * 访问地址 http://localhost:8762/actuator/hystrix.stream
     *
     * @param args
     */

    public static void main(String[] args) {

        SpringApplication.run(ServiceLucyApplication.class, args);
    }

}

