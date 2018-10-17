package com.springcloud.study;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class HelloApplication {

    private final Logger logger = Logger.getLogger(getClass());



    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
    @RequestMapping("/hello")
    public String index(){
        logger.info("/hello,host");
        return "Hello World";
    }
}
