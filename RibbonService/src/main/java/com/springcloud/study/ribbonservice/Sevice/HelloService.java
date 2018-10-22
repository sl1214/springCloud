package com.springcloud.study.ribbonservice.Sevice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @author chao.shen01@hand-china.com
 * @description
 * @Data 2018/10/19 10:39
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    private final org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(getClass());

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        long startTime = System.currentTimeMillis();

        String result =  restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        long endTime = System.currentTimeMillis();
        logger.info("Spend time:"+(endTime-startTime));
        return result;
    }

    public String helloFallback(){
        return "error";
    }
}
