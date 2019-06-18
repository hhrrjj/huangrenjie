package com.project.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * springboot项目的启动类
 * @author Mac Book Pro
 *
 */
@SpringBootApplication
@ComponentScan("com.project.controller")  //扫描某个目录下面的类，spring容器自动加载类对象
@ComponentScan("com.project.config")
@MapperScan("com.project.dao")
@ComponentScan("com.project.service")
//@EnableCaching
//@ComponentScan("com.project.listener")
public class SpringBoot0102Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot0102Application.class, args);
	}

}
