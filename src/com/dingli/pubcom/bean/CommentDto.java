package com.dingli.pubcom.bean;

public class CommentDto extends Comment {
	private String username;
	
	private Integer page;
	
	private Integer busId;
	
	private OrdersDto ordersDto;
	
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public OrdersDto getOrdersDto() {
		return ordersDto;
	}

	public void setOrdersDto(OrdersDto ordersDto) {
		this.ordersDto = ordersDto;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "CommentDto [username=" + username + ", page=" + page + ", busId=" + busId + ", ordersDto=" + ordersDto
				+ ", token=" + token + "]";
	}
	
	

}
