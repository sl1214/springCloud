package com.springcloud.study;

import com.springcloud.study.dto.User;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


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
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime"+sleepTime);
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        logger.info("/hello,host");
        return "Hello World";
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello "+name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello "+user.getName()+", "+user.getAge();
    }
}
