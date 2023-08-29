package com.jsp.HomeServo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HomeServoApplication {
    @Bean 
    public ModelMapper modelMapper() {
    	return new ModelMapper();
    }
	public static void main(String[] args) {
		SpringApplication.run(HomeServoApplication.class, args);
	}
	@Configuration
	public  class webConfig implements WebMvcConfigurer{
	    public void addCorsMappings(CorsRegistry registry) {
	    	registry.addMapping("/**")
	    	.allowedOrigins("*")
	    	.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
//	    	.allowedHeaders("*")
//            .exposedHeaders("Authorization")
//            .allowCredentials(true);
//	    	 .maxAge(3600);
	    	
            
	    	
               
	    }
	}

}
