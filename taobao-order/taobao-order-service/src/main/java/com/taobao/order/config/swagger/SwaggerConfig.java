package com.taobao.order.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:20 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String URL = "https://www.swagger.io";
    private static final String API_GROUP_NAME_OUT = "apis";
    private static final String API_GROUP_NAME_INTERNAL = "internal";

    private static final String API_VERSION = "V2.1";
    private static final String API_CONTACT_USER = "Lawrence Li";
    private static final String API_CONTACT_URL = URL;
    private static final String API_CONTACT_MAIL = "771279561@qq.com";

    private static final String API_TITLE = "Taobao Order Service";
    private static final String API_DESCRIPTION = "Taobao Order Service API Documents";
    private static final String APIS_PACKAGE_OUT = "com.taobao.order.controller";
    private static final String APIS_PACKAGE_INTERNAL = "com.taobao.order.controller";
    private static final String API_LICENSE = "OAS 2.0";
    private static final String API_LICENSE_URL = "https://github.com/OAI/OpenAPI-Specification/blob/master/versions/2.0.md";

    @Value("${swagger.switch}")
    private boolean SWAGGER_SWITCH;

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(API_GROUP_NAME_OUT)
                .select()
                .apis(RequestHandlerSelectors.basePackage(APIS_PACKAGE_OUT))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .enable(SWAGGER_SWITCH)
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .contact(new Contact(API_CONTACT_USER, API_CONTACT_URL, API_CONTACT_MAIL))
                .license(API_LICENSE)
                .licenseUrl(API_LICENSE_URL)
                .build();
    }


    @Bean
    public Docket apiDocketInternal() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(API_GROUP_NAME_INTERNAL)
                .select()
                .apis(RequestHandlerSelectors.basePackage(APIS_PACKAGE_INTERNAL))
                .build()
                .apiInfo(genApiInfoInternal())
                .enable(SWAGGER_SWITCH);
    }

    private ApiInfo genApiInfoInternal() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .contact(new Contact(API_CONTACT_USER, API_CONTACT_URL, API_CONTACT_MAIL))
                .license(API_LICENSE)
                .licenseUrl(API_LICENSE_URL)
                .build();
    }



}
