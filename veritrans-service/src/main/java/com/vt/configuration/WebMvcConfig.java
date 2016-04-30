package com.vt.configuration;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
class WebMvcConfig extends WebMvcAutoConfigurationAdapter {
	 /*@Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        
	        registry.addViewController("/").setViewName("home");
	    }*/
}
