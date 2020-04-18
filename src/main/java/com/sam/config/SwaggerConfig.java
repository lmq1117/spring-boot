package com.sam.config;


import jdk.jfr.Frequency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2 //开启swagger
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {

        //dev test环境开启swagger 生产环境不开启swagger
        Profiles profiles = Profiles.of("dev","test");





        return new Docket(DocumentationType.SWAGGER_2)
                //配置swagger信息start
                .apiInfo(apiInfo())
                //配置swagger基本信息end

                .enable(environment.acceptsProfiles(profiles)) //启用｜关闭swagger

                //配置swagger扫描哪些借口start
                .select()
                //配置要扫描借口的方式 只扫描 com.sam.controller包下面的 符合/sam/**的方法
                .apis(RequestHandlerSelectors.basePackage("com.sam.controller"))
                .paths(PathSelectors.ant("/sam/**"))
                .build()
                //配置swagger扫描哪些借口end

        ;
    }

    private ApiInfo apiInfo() {

        Contact contact = new Contact("小权","http://blog.lmqde.com","lmq1117@qq.com");
        return new ApiInfo(
                "狂神的swagger的读源码api借口文档",
                "生命在于折腾",
                "1.0",
                "http://www.lmqde.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
