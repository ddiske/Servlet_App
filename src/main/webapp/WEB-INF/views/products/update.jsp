<%@page import="com.root.app.products.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
</head>
<body>
	<div class="header">
		<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
	</div>
	<div class="contents">
		<nav class="nav">
			<ul class="contents_top">
				<li><a href="/products/list.do">돌아가기</a></li>
			</ul>

		</nav>
	</div>
	<div class="contents_main">
		<form action="./update.do?productnum=${pageScope.product.productNum }&&productrate=${pageScope.product.productRate}&&productdate=${pageScope.product.productDate}" method="post">
			<h3>상품 이율 : 
				<input type="text" name="productrate" value="${param.productrate}">
			</h3>
			<br>
			<h3>상품 상세정보 : 
				<input type="text" name="productdetail" value="${requestScope.productdetail }">
			</h3>
			<br>
			<input type="hidden" name="productnum" value="${requestScope.productnum }">
			<button type="submit">수정하기</button>
		</form>
	</div>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>