package com.aibibang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author：Truman.P.Du  
* @createDate: 2017年8月29日 下午2:13:02 
* @version:1.0
* @description:
*/
@Controller
public class IndexController {
	@RequestMapping({ "", "/" })
	public String index() {
		return "index";
	}

}
