package com.zyl.flowershop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FilePathConfig implements WebMvcConfigurer{
	
	@Value("${file.path}")
	private String path;
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler(path).addResourceLocations("file:" + System.getProperty("user.dir")+ "\\images\\");
		System.out.println(path);
		System.out.println(("file:" + System.getProperty("user.dir")+ "\\images\\"));
		
		}

}
