package com.dingli.pubcom.service;

import java.util.List;

import com.dingli.pubcom.bean.OrdersDto;
import com.dingli.pubcom.cacha.Order;

public interface OrdersService {
	public List<OrdersDto> OrderListForApi(OrdersDto ordersDto);
	
	public List<OrdersDto> ordersList(String phone);
	
	public Order createOrder(OrdersDto oDto);

}
