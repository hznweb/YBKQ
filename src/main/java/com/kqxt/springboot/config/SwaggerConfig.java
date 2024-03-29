package com.kqxt.springboot.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Swagger配置
 * 配置后，可以通过诸如下述方式访问：http://127.0.0.1:8080/kqxt_springboot/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .protocols(Sets.newHashSet("http")) //协议，http或https
                .apiInfo(apiInfo())
                .ignoredParameterTypes(ModelMap.class, HttpServletRequest.class, HttpServletResponse.class, HttpSession.class, BindingResult.class)//忽略这些类型的注释
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kqxt.web.backstage")) //自动在这个路径下扫描定义的api
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("易·学系统 RESTful API")
                .version("1.0")
                .description("易·学系统的RESTful API")
                .contact(new Contact("hzn", "无", "1245358572@qq.com"))//作者信息
                .build();
    }
}
