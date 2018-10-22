package com.springcloud.study.ribbonservice.Controller;

import com.springcloud.study.ribbonservice.Sevice.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chao.shen01@hand-china.com
 * @description
 * @Data 2018/10/11 11:20
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "testHello",method = RequestMethod.GET)
    public String helloConsumer(){
        //return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
        return helloService.helloService();
    }
}
