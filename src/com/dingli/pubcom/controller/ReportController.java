package com.dingli.pubcom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dingli.pubcom.bean.Option;
import com.dingli.pubcom.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService rs;
	
	@RequestMapping(value="/report")
	public String reportList() {
		return "report/orderCount";
	}
	
	@ResponseBody //以JSON返回
	@RequestMapping(value="/reportList")
	public Option getReport() {
		
		Option o = rs.getReport();

		return o;
	}
}
