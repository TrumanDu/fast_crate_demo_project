package com.aibibang.controller;

import javax.servlet.http.HttpSession;

import com.aibibang.constant.SessionAttr;
import com.aibibang.model.User;
import com.aibibang.util.ContextHolderUtil;

public class BaseController {
	/**
	 * 获取登录的当前用户信息
	 * 
	 * @return
	 */
	public User getCurrentUser(){
		
		HttpSession session = ContextHolderUtil.getSession();
		User user = (User)session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		
		return user;
	}
}
