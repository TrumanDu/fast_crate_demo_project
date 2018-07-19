package com.aibibang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aibibang.constant.SessionAttr;
import com.aibibang.model.PageModel;
import com.aibibang.model.TraditionalChineseMedicine;
import com.aibibang.model.User;
import com.aibibang.util.ContextHolderUtil;

/**
 * @author：Truman.P.Du
 * @createDate: 2018年6月2日 下午4:04:27
 * @version:1.0
 * @description:
 */
@Controller
public class IndexController {

	@RequestMapping({ "", "/" })
	public String index() {
		return "index";
	}

	@RequestMapping("/logout")
	public String logout() {
		HttpSession session = ContextHolderUtil.getSession();
		session.removeAttribute(SessionAttr.USER_LOGIN.getValue());
		return "index";
	}

	@RequestMapping("/home")
	public String home(Model model, TraditionalChineseMedicine query, HttpServletRequest request) {
		int pageNo = 0;
		String no = request.getParameter("pageNo");
		if (StringUtils.isNotEmpty(no)) {
			pageNo = Integer.parseInt(no);
		}
		List<TraditionalChineseMedicine> medicines = new ArrayList<>();
		PageModel<TraditionalChineseMedicine> page = new PageModel<TraditionalChineseMedicine>(medicines);
		page.setPageIndex(pageNo);
		model.addAttribute("page", page);
		model.addAttribute("queryParam", query);
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user) {
		HttpSession session = ContextHolderUtil.getSession();
		if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
			session.setAttribute(SessionAttr.USER_LOGIN.getValue(), user);
			return "redirect:home";
		}
		return "index";
	}
}
