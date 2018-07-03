package com.aibibang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aibibang.constant.SessionAttr;
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
	public String home(Model model,TraditionalChineseMedicine query,HttpServletRequest request) {
		int pageNo=0;
		String no = request.getParameter("pageNo");
		/*if(StringUtils.isNotEmpty(no)){
			pageNo = Integer.parseInt(no);
		}
		List<TraditionalChineseMedicine> medicines = new ArrayList<>();
		HBasePageModel page = hbaseService.getTraditionalChineseMedicines(pageNo, query, 10);
		
		List<Result> resultList = page.getResultList();
		for (Result rs : resultList) {

			try {
				TraditionalChineseMedicine medicine = new TraditionalChineseMedicine();
				medicine.setNo(Long.parseLong(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("no")))));
				medicine.setCol1(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col1")), "utf-8"));
				medicine.setCol2(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col2")), "utf-8"));
				medicine.setCol3(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col3")), "utf-8"));
				medicine.setCol4(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col4")), "utf-8"));
				medicine.setCol5(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col5")), "utf-8"));
				medicine.setCol6(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col6")), "utf-8"));
				medicine.setCol7(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col7")), "utf-8"));
				medicine.setCol8(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col8")), "utf-8"));
				medicine.setCol9(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col9")), "utf-8"));
				medicine.setCol10(new String(rs.getValue(Bytes.toBytes("info1"), Bytes.toBytes("col10")), "utf-8"));
				medicines.add(medicine);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}
		page.setData(medicines);
		model.addAttribute("page", page);*/
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
