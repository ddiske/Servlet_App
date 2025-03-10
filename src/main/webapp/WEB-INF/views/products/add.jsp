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
		<form action="./add.do" method="post">
			<h6>상품명 : </h6>
			<input type="text" name="productname"><br>
			<button type="submit">등록하기</button>
		</form>
	</div>
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	
</body>
</html>