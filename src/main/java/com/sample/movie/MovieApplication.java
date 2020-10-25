package com.sample.movie;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sample.movie.repository.MovieRepository;

import brave.sampler.Sampler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableJpaRepositories(basePackageClasses = MovieRepository.class)
@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}

	@Bean
	public Sampler defaultSampler() {
	   return Sampler.ALWAYS_SAMPLE;
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                                         
          .apis(RequestHandlerSelectors.basePackage("com.sample.movie.controller"))
          .paths(PathSelectors.ant("/**/**")) 
          .build()
          .apiInfo(apiInfo());                                           
    }
	
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Movies API", 
          "Movie Services", 
          "API TOS", 
          "Terms of service", 
          new Contact("Contact", "www.support.com", ""), 
          "License of API", "API license URL");
   } 
}
