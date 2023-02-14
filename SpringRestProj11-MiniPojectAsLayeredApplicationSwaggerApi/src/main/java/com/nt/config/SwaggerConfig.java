package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	
	public Docket creatDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
											.select()
											.apis(RequestHandlerSelectors.basePackage("com.nt.restcontroller"))
											.paths(PathSelectors.regex("/actor.*"))
											.build()
											.useDefaultResponseMessages(true)
											.apiInfo(createContact());
	}
	private ApiInfo createContact() {
		Contact contact=new Contact("Pradeep","Oracle" ,"pradeepwaghmode@gamil.com");
		return new ApiInfo("Actor Api","used For Actor Opearation management", "4.0.4", "https://www.oracle.com", 
				contact,  "GPU", "https://www.oracle.com",Collections.emptyList());
	}
	{
		System.out.println("SwaggerConfig.enclosing_method()");
	}
}
