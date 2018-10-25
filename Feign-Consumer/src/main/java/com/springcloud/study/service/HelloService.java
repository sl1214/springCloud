package com.springcloud.study.service;

import com.springcloud.study.dto.User;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author chao.shen01@hand-china.com
 * @description
 * @Data 2018/10/24 10:27
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name,@RequestHeader("age") Integer age);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
