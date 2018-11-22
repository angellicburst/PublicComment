package com.dingli.pubcom.bean;

import java.util.List;

public class BusinessData {
	private boolean hasMore;
	
	private List<BusinessDto> data;

	public boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

	public List<BusinessDto> getData() {
		return data;
	}

	public void setData(List<BusinessDto> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BusinessData [hasMore=" + hasMore + ", data=" + data + "]";
	}
	
}
