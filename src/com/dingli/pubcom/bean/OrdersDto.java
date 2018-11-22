package com.dingli.pubcom.bean;

public class OrdersDto extends Orders {
	private Member member;
	
	private BusinessDto businessDto;
	
	private String username;
	
	private String img;
	
	private String title;
	
	private Integer count;
	
	private String token;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BusinessDto getBusinessDto() {
		return businessDto;
	}

	public void setBusinessDto(BusinessDto businessDto) {
		this.businessDto = businessDto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "OrdersDto [member=" + member + ", businessDto=" + businessDto + ", username=" + username + ", img="
				+ img + ", title=" + title + ", count=" + count + ", token=" + token + "]";
	}

}
