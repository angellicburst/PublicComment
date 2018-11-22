package com.dingli.pubcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.pubcom.bean.Business;
import com.dingli.pubcom.bean.BusinessDto;
import com.dingli.pubcom.service.BusinessService;
import com.dingli.pubcom.service.DictionaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BusinessController {
	
	@Autowired
	private BusinessService bs;
	
	@Autowired
	private DictionaryService ds;
	
	@RequestMapping(value="/busList")
	public String busList(@RequestParam(value="pageIndex",defaultValue="1") Integer index,@RequestParam(value="titleInput",required=false) String titleInput,Model m) {
		PageHelper.startPage(index, 3);
		//System.out.println(titleInput);
		List<Business> buses = bs.busList(titleInput);
		//System.out.println(index+":"+buses.size());
		PageInfo<Business> pageInfo = new PageInfo<Business>(buses);
		
		m.addAttribute("pageInfo", pageInfo);
		m.addAttribute("titleInput", titleInput);
		
		return "content/businessList";
	}
	
	@RequestMapping(value="/busAdd")
	public String busAdd(Model m) {
		m.addAttribute("city", ds.dicList("city"));
		m.addAttribute("category", ds.dicList("category"));
		return "content/businessAdd";
	}
	
	@RequestMapping(value="/insertBus")
	public String insertBus(BusinessDto bDto) {
		bs.insertBus(bDto);
		return "redirect:/busList";
	}
	
	@RequestMapping(value="/busModify")
	public String busModify(@RequestParam(value="id") Integer id,@RequestParam(value="pageIndex") Integer pageIndex,Model m) {
		m.addAttribute("city", ds.dicList("city"));
		m.addAttribute("category", ds.dicList("category"));
		m.addAttribute("bus", bs.loadBus(id));
		m.addAttribute("pageIndex", pageIndex);
		return "content/businessModify";
	}
	
	@RequestMapping(value="/updateBus")
	public String updateBus(@RequestParam(value="pageIndex") Integer pageIndex,BusinessDto bDto) {
		bs.updateBus(bDto);
		return "redirect:/busList?pageIndex=" + pageIndex;
	}
	
	@RequestMapping(value="/deleteBus")
	public String deleteBus(@RequestParam(value="pageIndex") Integer pageIndex,@RequestParam(value="id") Integer id) {
		bs.deleteBus(id);
		return "redirect:/busList?pageIndex=" + pageIndex;
	}
}
