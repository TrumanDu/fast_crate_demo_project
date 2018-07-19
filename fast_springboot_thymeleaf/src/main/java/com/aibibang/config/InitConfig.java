package com.aibibang.config;
/** 
* @author：Truman.P.Du  
* @createDate: 2018年7月19日 下午1:08:16 
* @version:1.0
* @description:
*/

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;

@Component
public class InitConfig {

	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect(new GroupingStrategy());
	}
}
