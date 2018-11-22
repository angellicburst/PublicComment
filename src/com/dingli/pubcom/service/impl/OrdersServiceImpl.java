package com.dingli.pubcom.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dingli.pubcom.bean.Member;
import com.dingli.pubcom.bean.Orders;
import com.dingli.pubcom.bean.OrdersDto;
import com.dingli.pubcom.cacha.LoginCode;
import com.dingli.pubcom.cacha.Order;
import com.dingli.pubcom.dao.MemberMapper;
import com.dingli.pubcom.dao.OrdersMapper;
import com.dingli.pubcom.service.OrdersService;
import com.dingli.pubcom.util.ComUtil;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersMapper om;
	
	@Autowired
	private MemberMapper mm;
	
	@Value("${bus_img_url}")
	private String imgUrl;

	@Override
	public List<OrdersDto> OrderListForApi(OrdersDto ordersDto) {
		List<OrdersDto> ordersDtos = om.selectForApi(ordersDto);
		for (OrdersDto od : ordersDtos) {
			od.setImg(imgUrl + od.getBusinessDto().getImgFileName());
			od.setTitle(od.getBusinessDto().getTitle());
			od.setCount(od.getNum());
		}
		
		return ordersDtos;
	}

	@Override
	public Order createOrder(OrdersDto oDto) {
		Order o = new Order();
		
		LoginCode l = new LoginCode();
		l.setUsername(oDto.getUsername());
		Member m = mm.selectByPhone(l);
		
		//System.out.println(m);
		
		Orders os = new Orders();
		
		BeanUtils.copyProperties(oDto, os);
		
		os.setId(null);
		os.setBusinessId(oDto.getId());
		os.setMemberId(m.getId());
		os.setCommentState(0);
		os.setCreateTime(ComUtil.getNowTime());
				
		//System.out.println(os);
		if (om.insert(os) >= 1) {		
			o.setErrno(0);
			o.setMsg("购买成功");
		} else {
			o.setErrno(1);
			o.setMsg("购买失败");
		}
		
		return o;
	}

	@Override
	public List<OrdersDto> ordersList(String phone) {
		OrdersDto ordersDto = new OrdersDto();
		System.out.println(phone);
		if (phone !=null && !"".equals(phone)) {
			
			ordersDto.setUsername("%" + phone + "%");
			System.out.println(ordersDto.getUsername());
		}
		
		List<OrdersDto> oDtos = om.selectAllOrders(ordersDto);
		return oDtos;
	}
	
}
