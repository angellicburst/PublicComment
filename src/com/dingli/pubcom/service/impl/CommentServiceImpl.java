package com.dingli.pubcom.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingli.pubcom.bean.Comment;
import com.dingli.pubcom.bean.CommentDto;
import com.dingli.pubcom.bean.Orders;
import com.dingli.pubcom.cacha.ComMsg;
import com.dingli.pubcom.dao.CommentMapper;
import com.dingli.pubcom.dao.OrdersMapper;
import com.dingli.pubcom.service.CommentService;
import com.dingli.pubcom.util.ComUtil;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper cm;
	
	@Autowired
	private OrdersMapper om;
	
	@Override
	public List<CommentDto> comListForApi(CommentDto cDto) {
		List<CommentDto> cDtos = cm.selectByOrderIdForApi(cDto);
		for (CommentDto commentDto : cDtos) {
			commentDto.setUsername(commentDto.getOrdersDto().getMember().getPhone().toString());
			//System.out.println(commentDto);
		}
		return cDtos;
	}

	@Override
	public ComMsg subCommentForApi(CommentDto cDto) {
		ComMsg c = new ComMsg();
		
		Comment comment = new Comment();
		
		BeanUtils.copyProperties(cDto, comment);
		
		comment.setId(null);
		comment.setOrdersId(cDto.getId());
		comment.setCreateTime(ComUtil.getNowTime());
		
		System.out.println(comment);
		
		if (cm.insert(comment) >= 1) {
			c.setErrno(0);
			c.setMsg("评论成功");
			Orders o = om.selectByPrimaryKey(cDto.getId());
			o.setCommentState(2);
			om.updateByPrimaryKey(o);
		} else {
			c.setErrno(1);
			c.setMsg("评论失败");
		}
		
		return c;
	}

	@Override
	public List<CommentDto> comList(String com) {
		Comment c = new Comment();
		System.out.println(com);
		if (com != null && !"".equals(com)) {
			c.setComment("%" + com + "%");
			System.out.println(c.getComment());
		}	
		List<CommentDto> coms = cm.selectAllCom(c);
		return coms;
	}

}
