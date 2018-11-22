package com.dingli.pubcom.bean;

import java.util.List;

public class XAxis {
	private List<String> data;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "XAxis [data=" + data + "]";
	}
	
	
}
