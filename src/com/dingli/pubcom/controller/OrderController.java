package com.dingli.pubcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dingli.pubcom.bean.OrdersDto;
import com.dingli.pubcom.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class OrderController {
	
	@Autowired
	private OrdersService os;

	@RequestMapping(value="/orderList")
	public String orderList(@RequestParam(value="pageIndex",defaultValue="1") Integer pageNum,@RequestParam(value="phoneInput",required=false) String phoneInput,Model model) {

		PageHelper.startPage(pageNum, 3);
		List<OrdersDto> ordersDtos = os.ordersList(phoneInput);
		
		PageInfo<OrdersDto> pageInfo = new PageInfo<OrdersDto>(ordersDtos);
		
		model.addAttribute("orders", pageInfo);
		model.addAttribute("phoneInput", phoneInput);
		
		return "content/orderList";
	}
}
