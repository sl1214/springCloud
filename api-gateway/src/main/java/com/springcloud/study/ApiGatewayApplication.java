package com.springcloud.study;

import com.springcloud.study.Filter.AccessFilter;
import com.springcloud.study.Filter.ThrowExceptionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    /*@Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }*/

    @Bean
    public ThrowExceptionFilter throwExceptionFilter(){
        return new ThrowExceptionFilter();
    }
}
