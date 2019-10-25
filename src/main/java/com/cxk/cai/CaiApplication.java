package com.cxk.cai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 喜闻乐见i
 */
@SpringBootApplication
@MapperScan("com.cxk.cai.mapper")
@EnableSwagger2
public class CaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaiApplication.class, args);
    }

}
