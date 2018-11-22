<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/all.css" />
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/pop.css" />
		<link rel="stylesheet" type="text/css" href="<%=basepath%>/static/css/main.css" />
		<script type="text/javascript" src="<%=basepath%>/static/js/common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="<%=basepath%>/static/js/content/orders.js" ></script>

	</head>

	<body style="background: #e1e9eb;">
		<input type="hidden" name="basepath" value="${basepath}" />
		<input type="hidden" name="phoneInput" value="${phoneInput }" />
		<form action="" id="mainForm" method="post">
		
			<div class="right">
				<div class="current">当前位置：
					<a href="#">内容管理</a> &gt; 订单查询</div>
				<div class="rightCont">
					<p class="g_title fix">订单列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="80" align="right">手机号：</td>
								<td>
									<input name="title" id="title" value="" class="allInput" type="text" />
								</td>
								<td style="text-align: right;" width="150">
									<input class="tabSub" value="查询" onclick="search()" type="button" />&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
									<th>序号</th>
									<th>手机号</th>
									<th>订单号</th>
									<th>金额(元)</th>
								</tr>
								<c:forEach items="${orders.getList() }" var="o">
								<tr>
									<td>${o.getId() }</td>
									<td>${o.getMember().getPhone() }</td>
									<td>${o.getId() }</td>
									<td>${o.getPrice() }</td>
								</tr>									
								</c:forEach>


							</tbody>
						</table>

						<!-- 分页 -->

						<div class="page fix">
							<a href="" onclick="firstPage()" class="first">首页</a>
							<c:if test="${orders.isHasPreviousPage() }">
								<a href="" onclick="prePage()" class="pre">上一页</a>
							</c:if>
							当前第<span id="pageIndex">${orders.getPageNum() }</span>/<span id="pageCount">${orders.getPages() }</span>页
							<c:if test="${orders.isHasNextPage() }">
								<a href="" onclick="nextPage()" class="next">下一页</a>
							</c:if>
							<a href="" onclick="lastPage()" class="last">末页</a> 跳至 &nbsp;
							<input type="text" id="currentPageText" value="1" class="allInput w28" />&nbsp;页 &nbsp;
							<a href="" onclick="runToPage()" class="go">GO</a>
						</div>
					</div>
				</div>
			</div>
		</form>

	</body>

</html>