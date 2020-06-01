package com.example.movie.catalog.service;

import com.example.movie.catalog.service.Client.ClientRepository;
//import com.example.movie.catalog.service.User.UserRepository;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2//springfox swagger2    dynamic javadoc tool
@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MovieCatalogResourceApplication {

	@Bean
	@LoadBalanced//used with Eureka
	public RestTemplate getRestTemplate(){
		//adding timeout to manage threads and working speed
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}

	@Bean
	@LoadBalanced//used with Eureka
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	@Bean
	public Docket swagerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.paths(PathSelectors.ant(("/api/*")))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo(){
		return new ApiInfo(
				"title: Movie Catalog Service",
				"description: second row",
				"version: 1.0",
				"turms of service: free",
				new Contact("contact: roy", "url:", "email"),
				"licence",
				"licence url",
				Collections.emptyList()
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogResourceApplication.class, args);
	}

}
