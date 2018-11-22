package com.dingli.pubcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.pubcom.bean.CommentDto;
import com.dingli.pubcom.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	@RequestMapping(value="/comList")
	public String comList(@RequestParam(value="pageIndex",defaultValue="1") Integer pageNum,@RequestParam(value="comInput",required=false) String comInput,Model model) {
		PageHelper.startPage(pageNum, 3);
		List<CommentDto> coms = cs.comList(comInput);
		
		PageInfo<CommentDto> pageInfo = new PageInfo<CommentDto>(coms);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("comInput", comInput);
		return "content/commentList";
	}
}
