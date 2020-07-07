
package com.ibm.product.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//@Configuration 
//@EnableSwagger2WebMvc
//@Import(SpringDataRestConfiguration.class)
//public class SwaggerConfig { // configure
//
//	@Bean
//	public Docket docket() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
//	}
//
//	// create api metadata that goes at the top of the generated page private
//	ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("HealthCare Resources Management API")
//				.description("Healthcare Product Management API")
//				.contact(new Contact("Prasanna Hinge", "http://roboleary.design", ""))
//				.license("Apache License Version 2.0").version("1.0").build();
//	}
//
//}
