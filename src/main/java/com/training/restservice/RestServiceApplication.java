package com.training.restservice;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.MapInfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.training.controller",
		"com.training.serviceimpl"
		})
@EnableSwagger2
@EnableMongoRepositories("com.tarining.mongodb.repository")
public class RestServiceApplication {
	
	@Autowired 
	private MongoDbFactory mongoDbFactory;
	 
	  @Autowired private MongoMappingContext 
	  mongoMappingContext;

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.training.controller")).build();
	   }
	
	
	 
	  @Bean
	  public MappingMongoConverter mappingMongoConverter() {
	 
	    DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
	    MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
	    converter.setTypeMapper(new DefaultMongoTypeMapper(null));
	 
	    return converter;
	  }
	  
	  @Bean
	  public MapInfoContributor mapInfoContributor() {
	      return new MapInfoContributor(new HashMap<String, Object>() {{
	          put("Training", "Spring Boot");
	      }});
	  }
	 

}
