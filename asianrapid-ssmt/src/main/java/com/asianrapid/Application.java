package com.asianrapid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: wangminghao
 * @Description:
 * @Date: Created in 上午 9:32 2018/2/9 0009
 */
@SpringBootApplication
@MapperScan(basePackages = "com.asianrapid.dao")
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
