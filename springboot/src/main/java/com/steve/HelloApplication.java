package com.steve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Author Loujitao
 *@SpringBootApplication：Spring Boot项目的核心注解，主要目的是开启自动配置
 *@Configuration：这是一个配置Spring的配置类；
 */
@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {

   @RequestMapping("hello")
   @ResponseBody
    public String hello() {
        return "hello world!";
    }
    /**
     * @Author Loujitao
     *  springboot的入口方法
     *  页面地址栏输入：http://127.0.0.1:8080/hello
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class,args);
    }
}
