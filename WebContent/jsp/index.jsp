<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #666;
    font-size: 22px;
    font-weight: normal;
    padding-right:17px;
}
 </style>
</head>
<body>

<%@ include file="/jsp/header.jsp" %>

<div class="container-fluid">
	<div class="col-md-12">
		<h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
	</div>
	<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
		<img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
	</div>
	<div class="col-md-10">
		<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
			<a href="product_info.htm">
				<img src="products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
			</a>
		</div>
		<c:forEach items="${news}" var="p">
			<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
				<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}">
					<img src="${pageContext.request.contextPath}/${p.pimage}" width="130" height="130" style="display: inline-block;">
				</a>
				<p><a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}" style='color:#666'>${p.pname}</a></p>
				<p><font color="#E4393C" style="font-size:16px">&yen;${p.shop_price}</font></p>
			</div>
		</c:forEach>

	</div>
</div>
<!--

    描述：商品显示
-->
<div class="container-fluid">
	<div class="col-md-12">
		<h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
	</div>
	<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
		<img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
	</div>
	<div class="col-md-10">
		<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
			<a href="product_info.htm">
				<img src="products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
			</a>
		</div>

		<c:forEach items="${hots}" var="p">
			<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
				<a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}">
					<img src="${pageContext.request.contextPath}/${p.pimage}" width="130" height="130" style="display: inline-block;">
				</a>
				<p><a href="${pageContext.request.contextPath}/ProductServlet?method=findProductByPid&pid=${p.pid}" style='color:#666'>${p.pname}</a></p>
				<p><font color="#E4393C" style="font-size:16px">&yen;${p.shop_price}</font></p>
			</div>
		</c:forEach>


	</div>
</div>

</body></html>