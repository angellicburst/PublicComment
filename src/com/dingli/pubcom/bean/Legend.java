package com.dingli.pubcom.bean;

import java.util.Set;

public class Legend {
	private Set<String> data;

	public Set<String> getData() {
		return data;
	}

	public void setData(Set<String> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Legend [data=" + data + "]";
	}
	
	
}
