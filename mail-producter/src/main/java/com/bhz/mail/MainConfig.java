/**
 * Copyright 2017 JINZAY All Rights Reserved.
 */
package com.bhz.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author bhz
 * @since 2017年2月8日 下午1:28:48
 */
@EnableWebMvc		//启用了spring mvc
@Configuration		// 让spring boot 项目启动时识别当前配置类
@ComponentScan({"com.bhz.mail.*"})	//
@MapperScan(basePackages = "com.bhz.mail.mapper")
//@ImportResource
public class MainConfig {

	
	
}
