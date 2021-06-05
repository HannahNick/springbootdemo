package com.nick.springboot.config;

import com.nick.springboot.controller.OrderController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 开启Swagger
 * http://localhost:9901/swagger-ui.html  查看Swagger是否正常运行
 * 测试运行
 * @author zwj
 * @date 2021/6/5
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(Environment environment){

        //设置要显示的Seagger环境
        Profiles profiles = Profiles.of("dev", "test");
        //通过Environment.acceptsProfiles判断是否处在自己设定的环境中
        boolean enable = environment.acceptsProfiles(profiles);
        System.out.println(enable);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //如果是false则Swagger不能在浏览器中访问
                .enable(enable)
                .select()
                //RequestHandlerSelectors,配置要扫描的接口
                //basePackage:指定要扫描的包
                //any():扫描全部
                //none():不扫描
                //withClassAnnotation:扫描类上的注解,参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解,参数是一个注解的反射对象
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("com.nick.springboot.controller"))
                //过滤哪些路径
//                .paths(PathSelectors.ant("com.*"))
                .build()
                ;
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Nick","https://www.baidu.com","365719562@qq.com");
        return new ApiInfo(
                "Nick的SwaggerAPI文档",
                "Nick要变强",
                "v1.1",
                "https://www.baidu.com",
                contact,
                "Apache 2.0",
                "https://www.baidu.com",
                new ArrayList<>());
    }

}
