<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h6 {
		display: inline-block;
	}
</style>
</head>
<body>
	<h3>지역 정보 추가</h3>
	<form action="./addProcess.jsp" method="post">
		<h6>도시명 : </h6><input type="text" name="city"><br>
		<h6>지역명 : </h6><input type="text" name="state_province"><br>
		<h6>주소 : </h6><input type="text" name="street_address"><br>
		<h6>우편번호 : </h6><input type="text" name="postal_code"><br>
		<h6>국가ID : </h6><input type="text" name="country_id"><br>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>