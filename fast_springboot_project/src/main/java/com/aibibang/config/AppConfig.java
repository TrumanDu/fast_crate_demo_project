package com.aibibang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author：Truman.P.Du
 * @createDate: 2017年8月29日 上午9:41:41
 * @version:1.0
 * @description:
 */
@Component
public class AppConfig {
	@Value("${elasticsearch.rest.urls}")
	private String elasticsearch_rest_urls;

	public String getElasticsearch_rest_urls() {
		return elasticsearch_rest_urls;
	}

	public void setElasticsearch_rest_urls(String elasticsearch_rest_urls) {
		this.elasticsearch_rest_urls = elasticsearch_rest_urls;
	}

}
