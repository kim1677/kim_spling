package com.BookProject.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/static/css/")
				.setCachePeriod(3600);
		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/static/js/")
				.setCachePeriod(3600);
		registry.addResourceHandler("/img/**")
				.addResourceLocations("file:///C:/img/")
				.setCachePeriod(3600);
	}
}
