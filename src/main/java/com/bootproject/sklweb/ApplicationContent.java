package com.bootproject.sklweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 启动springboot主程序
 * @author  uu04418
 * @date  2019年7月21日  下午4:46:15
 */
@SpringBootApplication

@MapperScan(value = "com.bootproject.sklweb.mapper,com.bootproject.sklweb.mymapper")
public class ApplicationContent {
	public static void main (String [] args) {
		SpringApplication.run(ApplicationContent.class, args) ;
	}
}
