package com.springcloud.study.controller;

import com.springcloud.study.dto.User;
import com.springcloud.study.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chao.shen01@hand-china.com
 * @description
 * @Data 2018/10/24 10:28
 */
@RestController
public class ConsumerController {

    private final org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(getClass());

        @Autowired
        HelloService helloService;

        @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
        public String helloConsumer () {
            long startTime = System.currentTimeMillis();
            String result = helloService.hello();
            long endTime = System.currentTimeMillis();
            logger.info("Spend time:"+(endTime-startTime));
            return result;
        }

        @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
        public String helloConsumer2(){
            StringBuilder sb = new StringBuilder();
            sb.append(helloService.hello()).append("\n");
            sb.append(helloService.hello("DIDI")).append("\n");
            sb.append(helloService.hello("DIDI",30)).append("\n");
            sb.append(helloService.hello(new User("DIDI",30))).append("\n");
            return sb.toString();
        }
    }
