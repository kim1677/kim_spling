package com.bookProject.Config;

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
		registry.addResourceHandler("/image/**")
				.addResourceLocations("classpath:/static/image/bimg/")
        		.addResourceLocations("classpath:/static/image/")
				.setCachePeriod(3600);
	}
}

