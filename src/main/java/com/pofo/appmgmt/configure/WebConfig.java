package com.pofo.appmgmt.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pofo.appmgmt.common.configure.CorsFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);
	
	@Bean
	public FilterRegistrationBean<MultipartFilter> multipartFilterRegistrationBean() {
		FilterRegistrationBean<MultipartFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MultipartFilter());
		registrationBean.setOrder(0);
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> getFilterRegistrationBean() {
		FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(new CorsFilter());
		registrationBean.setOrder(1);
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
	
}
