package com.dingli.pubcom.bean;

import java.util.List;

public class CommentData {
	private Boolean hasMore;
	
	private List<CommentDto> data;

	public Boolean getHasMore() {
		return hasMore;
	}

	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}

	public List<CommentDto> getData() {
		return data;
	}

	public void setData(List<CommentDto> data) {
		this.data = data;
	}

}
