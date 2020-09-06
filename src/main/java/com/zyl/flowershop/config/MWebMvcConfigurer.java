package com.zyl.flowershop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zyl.flowershop.config.interceptor.AdmInterceptor;

@Configuration
public class MWebMvcConfigurer implements WebMvcConfigurer {

	@Value("${file.path}")
	private String path;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(path).addResourceLocations("file:" + System.getProperty("user.dir") + "\\images\\");
		System.out.println(path);
		System.out.println(("file:" + System.getProperty("user.dir") + "\\images\\"));
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器
		InterceptorRegistration admRegistry = registry.addInterceptor(new AdmInterceptor());
//		// 拦截路径
		admRegistry.addPathPatterns("/back/super");
		admRegistry.addPathPatterns("/back/normal", "/back/super", "/*/find", "/*/findAll", "/*/insert", "/*/update");
	}

}
