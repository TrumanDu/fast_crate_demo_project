package com.aibibang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aibibang.domain.ConfigInfo;
import com.aibibang.mapper.ConfigInfoMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author：Truman.P.Du
 * @createDate: 2017年8月29日 下午2:02:14
 * @version:1.0
 * @description:
 */
@Controller
@RequestMapping("/ttl")
public class ConfigInfoController {
	@Autowired
	private ConfigInfoMapper configInfoMapper;

	@RequestMapping("/list")
	public String list(Model model) {
		List<ConfigInfo> results = configInfoMapper.findAll();
		model.addAttribute("results", results);
		return "ttl";
	}

	@RequestMapping("/add")
	public String add(ConfigInfo configInfo) {
		configInfoMapper.add(configInfo);
		return "ttl";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public String update(@RequestParam("id") Long id) {
		ConfigInfo configInfo = configInfoMapper.findById(id);
		return JSON.toJSONString(configInfo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(ConfigInfo configInfo) {
		configInfoMapper.update(configInfo);
		JSONObject json = new JSONObject();
		json.put("S", "success");
		return json.toJSONString();
	}


	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		configInfoMapper.Delete(id);
		return "ttl";
	}

}
