package com.project.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.filter.TestFilter;

/**
 * @Configuration表示当前注解是一个配置注解
 * @author Mac Book Pro
 * @Bean 对象
 *
 */
@Configuration
public class FilterConfig {
	@Bean   //创建一个bean对象
	public FilterRegistrationBean testFilter(){
		FilterRegistrationBean filterbean = new FilterRegistrationBean<>();
		filterbean.setFilter(new TestFilter());  //filter-class
		filterbean.addUrlPatterns("/*");   // filterbean
		filterbean.setOrder(0);   //启动级别 值越小级别越高
		
		return filterbean;
				
	}
}
