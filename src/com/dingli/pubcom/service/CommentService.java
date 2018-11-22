package com.dingli.pubcom.service;

import java.util.List;

import com.dingli.pubcom.bean.CommentDto;
import com.dingli.pubcom.cacha.ComMsg;

public interface CommentService {
	public List<CommentDto> comList(String com);
	
	public List<CommentDto> comListForApi(CommentDto cDto);
	
	public ComMsg subCommentForApi(CommentDto cDto);
}
