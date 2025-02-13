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
				<li><a href="/products/list.do">상품 목록</a></li>
				<li><a href="/products/add.do">상품 등록</a></li>
				<li><a href="/products/update.do?productnum=${product.productNum }&&productrate=${product.productRate}&&productdetail=${product.productDetail}">정보 수정</a></li>
				<li><a href="/accounts/add.do?productnum=${product.productNum }">가입하기</a></li>
			</ul>

		</nav>
	</div>

	<div class="contents_main">
		<div class="contents_detail">
			<h3>상품명 : ${requestScope.product.productName }</h3>
			<br>
			<h3>이자율 : ${requestScope.product.productRate }</h3>
			<br>
			<h3>기간 : ${requestScope.product.productDate }</h3>
			<br>
			<h3>상세 : ${requestScope.product.productDetail }</h3>
			<br>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>