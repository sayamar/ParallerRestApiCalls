package com.tcs.angular.angular4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
/**
 * 
 * @author Maruthi Sayampu
 *
 */
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public Docket bankApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	            .paths(PathSelectors.any())
	            .build();            
	}
	
	
}














/* @Bean
public Docket appApi() {
    AuthorizationScope[] authScopes = new AuthorizationScope[1];
    authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access").build();
    SecurityReference securityReference = SecurityReference.builder().reference("Authorization-Key")
            .scopes(authScopes).build();

    ArrayList<SecurityContext> securityContexts = newArrayList(
            SecurityContext.builder().securityReferences(newArrayList(securityReference)).build());
    return new Docket(DocumentationType.SWAGGER_2)
            .securitySchemes(newArrayList(new ApiKey("Authorization-Key", "Authorization", "header")))
            .securityContexts(securityContexts).apiInfo(apiInfo()).select().build();
}


private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Swagger API Security REST API")
            .description("\"Swagger API Security REST API\"").version("1.0.0").build();
}*/



