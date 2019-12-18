package com.bootproject.sklweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bootproject.sklweb.filter.CommonInterceptor;

//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	CommonInterceptor commonInterceptor() {
		return new CommonInterceptor();

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor());
	}

	/*
	 * @Bean //将组件注册在容器 public WebMvcConfigurerAdapter
	 * webMvcConfigurerAdapter(){ WebMvcConfigurerAdapter adapter = new
	 * WebMvcConfigurerAdapter() {
	 * 
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * 
	 * registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
	 * super.addInterceptors(registry); } }; return adapter; }
	 */

}
