package com.aibibang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aibibang.model.UserInfo;
import com.aibibang.service.UserMapper;

/**
 * @author: Truman.P.Du
 * @since: 2016年6月25日 下午5:06:09
 * @version: v1.0
 * @description:
 */
@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = { "", "/" })
	public String index(String name, Model model) {

		return "login";
	}

	@RequestMapping("/login")
	public String login(UserInfo userInfo, Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		boolean flag = false;
		if (userInfo == null || "".equals(userInfo.getPasswd()) || userInfo.getPasswd() == null) {
			userInfo = (UserInfo) session.getAttribute("userInfo");
			flag = true;
		}
		if (userInfo == null) {
			model.addAttribute("message", "please login again!");
			return "login";
		}

		UserInfo sessionUser = (UserInfo) session.getAttribute("userInfo");
		if (sessionUser != null && sessionUser.getUserName() != null) {
			return "index";
		} else {
			List<UserInfo> results = userMapper.getUserInfoByLogin(userInfo);
			if (results != null && results.size() > 0) {
				if (!flag) {
					session.setAttribute("userInfo", userInfo);
				}
				return "index";
			}
		}

		model.addAttribute("message", "Accout or Passwd is not correct!");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
}
