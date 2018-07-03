package com.aibibang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author: Truman.P.Du
 * @since: 2016年6月25日 下午5:06:35
 * @version: v1.0
 * @description: 程序启动入口
 */
@SpringBootApplication
public class RunServer extends SpringBootServletInitializer {
	private static Logger log = LoggerFactory.getLogger(RunServer.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RunServer.class, args);
		log.info("server Started");
	}
}
