package com.dingli.pubcom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.pubcom.bean.Advance;
import com.dingli.pubcom.bean.AdvanceDto;
import com.dingli.pubcom.service.AdvanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class AdvanceController {
	
	@Value("${ad_page_size}")
	private int pageSize;
	
	@Autowired
	private AdvanceService adService;
	
	@RequestMapping(value="/adList")
	public String adList(HttpServletRequest request,@RequestParam(value="pageIndex",defaultValue="1") Integer pageNum,@RequestParam(value="titleInput",required=false) String titleInput,Model m) {
//		System.out.println(pageSize);
//		System.out.println(titleInput);
		
		//第几页，一页几个
		PageHelper.startPage(pageNum,pageSize);
		List<Advance> advances = adService.adlist(titleInput);
//		for (Advance advance : advances) {
//			System.out.println(advance);
//		}
		
		PageInfo<Advance> pageInfo = new PageInfo<Advance>(advances);
		//当前第几页getPageNum 总页数getPages 分页集合getList
		m.addAttribute("advances", pageInfo);
		m.addAttribute("titleInput", titleInput);
		return "content/adList";
	}
	
	@RequestMapping(value="/adAdd")
	public String adAdd() {
		return "content/adAdd";
	}
	
	@RequestMapping(value="/insertAd")
	public String insertAd(AdvanceDto aDto) {
		adService.insertAd(aDto);
		return "redirect:/adList";		
	}
	
	@RequestMapping(value="/adModify")
	public String adModify(@RequestParam(value="id") Integer id,@RequestParam(value="pageIndex") Integer pageIndex,Model m) {
		AdvanceDto advance = adService.loadAd(id);
		m.addAttribute("advance", advance);
		m.addAttribute("pageIndex", pageIndex);
		return "content/adModify";
	}
	
	@RequestMapping(value="/updateAd")
	public String updateAd(AdvanceDto aDto,@RequestParam(value="pageIndex") Integer pageIndex) {
		adService.updateAd(aDto);
		return "redirect:/adList?pageIndex=" + pageIndex;
	}
	
	@RequestMapping(value="/deleteAd")
	public String deleteAd(@RequestParam(value="id") Integer id,@RequestParam(value="pageIndex") Integer pageIndex) {
		adService.deleteAd(id);
		return "redirect:/adList?pageIndex=" + pageIndex;
	}
}
