package com.aibibang.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author：Truman.P.Du
 * @createDate: 2017年8月29日 上午9:56:19
 * @version:1.0
 * @description:
 */
@Component
public class InitSystem implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(InitSystem.class);
	@Autowired
	AppConfig appConfig;

	@Override
	public void run(String... arg0) throws Exception {
		//appConfig.getElasticsearch_rest_urls();
		LOG.info("self config init success!");
	}

}
