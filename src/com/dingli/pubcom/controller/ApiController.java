package com.dingli.pubcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dingli.pubcom.bean.AdvanceDto;
import com.dingli.pubcom.bean.BusinessData;
import com.dingli.pubcom.bean.BusinessDto;
import com.dingli.pubcom.bean.CommentData;
import com.dingli.pubcom.bean.CommentDto;
import com.dingli.pubcom.bean.OrdersDto;
import com.dingli.pubcom.cacha.ComMsg;
import com.dingli.pubcom.cacha.LoginCode;
import com.dingli.pubcom.cacha.Order;
import com.dingli.pubcom.service.AdvanceService;
import com.dingli.pubcom.service.BusinessService;
import com.dingli.pubcom.service.CommentService;
import com.dingli.pubcom.service.MemberService;
import com.dingli.pubcom.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class ApiController {
	@Autowired
	private AdvanceService as;
	
	@Autowired
	private BusinessService bs;
	
	@Autowired
	private CommentService cs;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private OrdersService os;
	
	@Value("${ad_page_size}")
	private Integer adPageSize;
	
	@Value("${bus_page_size}")
	private Integer busPageSize;

	//首页广告数据接口
	@RequestMapping(value="/api/homead")
	public List<AdvanceDto> getAllAdForApi() {
		PageHelper.startPage(4, adPageSize);
		List<AdvanceDto> ads = as.adlistForApi();
		
		PageInfo<AdvanceDto> pageInfo = new PageInfo<AdvanceDto>(ads);
		
		return pageInfo.getList();
	}
	
	//商品数据接口  	@PathVariable(value="city")
	@RequestMapping(value="/api/homelist/{city}/{page}")
	public BusinessData getAllBusForApi(BusinessDto bDto) {
		//System.out.println(bDto.getPage());
		bDto.setPage(bDto.getPage() + 1);
		PageHelper.startPage(bDto.getPage(), busPageSize);
		List<BusinessDto> bus = bs.buslistForApi(bDto);
		
		PageInfo<BusinessDto> pageInfo = new PageInfo<BusinessDto>(bus);
		
		BusinessData bData = new BusinessData();
		bData.setHasMore(!pageInfo.isIsLastPage());
		bData.setData(pageInfo.getList());
		return bData;
	}
	
	//商品数据接口 三参数
	@RequestMapping(value="/api/search/{page}/{city}/{category}/{keyword}")
	public BusinessData getAllBusForApiSearch(BusinessDto bDto) {
		bDto.setPage(bDto.getPage() + 1);
		PageHelper.startPage(bDto.getPage(), busPageSize);
		List<BusinessDto> bus = bs.buslistForApi(bDto);
		PageInfo<BusinessDto> pageInfo = new PageInfo<BusinessDto>(bus);
		
		BusinessData bData = new BusinessData();
		bData.setHasMore(pageInfo.isHasNextPage());
		bData.setData(pageInfo.getList());
	
		return bData;	
	}
	
	@RequestMapping(value="/api/detail/info/{id}")
	public BusinessDto getDetailForApi(@PathVariable(value="id") Integer id) {
		BusinessDto bDto = bs.busDetailForApi(id);
		return bDto;
	}
	
	@RequestMapping(value="/api/detail/comment/{page}/{id}")
	public CommentData getCommentForApi(CommentDto cDto) {
		cDto.setBusId(cDto.getId());
		cDto.setPage(cDto.getPage() + 1);
		PageHelper.startPage(cDto.getPage(),3);
		List<CommentDto> cDtos = cs.comListForApi(cDto);
		PageInfo<CommentDto> pageInfo = new PageInfo<CommentDto>(cDtos);
		CommentData cData = new CommentData();
		cData.setHasMore(pageInfo.isHasNextPage());
		cData.setData(pageInfo.getList());
		return cData;
	}
	
	@RequestMapping(value="/api/login")
	public LoginCode loginForApi(LoginCode loginCode) {
		
		LoginCode l = ms.CheckLogin(loginCode);
		
		return l;
	}
	
	@RequestMapping(value="/api/sms")
	public LoginCode smsForApi(LoginCode loginCode) {
		
		LoginCode lc = ms.CheckLoginCode(loginCode);
		
		return lc;
	}
	
	@RequestMapping(value="/api/orderlist/{username}")
	public List<OrdersDto> orderListForApi(OrdersDto ordersDto) {
		return os.OrderListForApi(ordersDto);
	}
	
	@RequestMapping(value="/api/order")
	public Order orderForApi(OrdersDto oDto) {
		System.out.println(oDto.getPrice());
		Order o = os.createOrder(oDto);
		return o;
	}
	
	@RequestMapping(value="/api/submitComment")
	public ComMsg subComment(CommentDto cDto) {
		
		ComMsg cm = cs.subCommentForApi(cDto);
		
		return cm;
	}
	
}
