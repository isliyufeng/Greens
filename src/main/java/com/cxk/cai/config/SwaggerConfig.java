package com.cxk.cai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author 喜闻乐见i
 */
@Configuration
public class SwaggerConfig {
    /**
     * 创建文档说明
     *
     * @return ApiInfo
     */
    public ApiInfo createApiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("Cai系统接口")
                .description("实现一款时蔬鲜果购买同城派送商城的数据接口")
                .contact(new Contact("Lyf", "http://www.joyous.fun", "isliyufeng@163.com"))
                .build();
        return apiInfo;
    }

    /**
     * 创建Swagger扫描信息
     *
     * @return Docket
     */
    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cxk.cai.controller"))
                .build();
    }
}
