package it.uniroma3.galleria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class GalleriaApplication{

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
//		return application.sources(GalleriaApplication.class);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(GalleriaApplication.class, args);
	}
	
	
}
