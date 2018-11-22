package com.dingli.pubcom.bean;

import java.util.List;

public class Series {
	private String name;
	private String type;
	private String stack;
	private String areaStyle;
	private List<Integer> data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public String getAreaStyle() {
		return areaStyle;
	}
	public void setAreaStyle(String areaStyle) {
		this.areaStyle = areaStyle;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Series [name=" + name + ", type=" + type + ", stack=" + stack + ", areaStyle=" + areaStyle + ", data="
				+ data + "]";
	}
	
}
