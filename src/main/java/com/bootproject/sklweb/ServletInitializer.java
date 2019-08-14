package com.bootproject.sklweb;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * @Description 打包成war包这个类必须要。并且内置tomcat 需要屏蔽
 * @author  uu04418
 * @date  2019年8月1日  下午6:28:51
 */
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationContent.class);
	}

}
