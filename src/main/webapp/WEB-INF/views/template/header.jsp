<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="headbox">
	<a href="/index.do" class="logo"></a>
	<ul>
		<c:if test="${empty user }">
			<li><a href="/users/login.do">로그인</a></li>
			<li><a href="/users/join.do">회원가입</a></li>
		</c:if>
		<c:if test="${not empty user }">
			<li><a href="/users/logout.do">로그아웃</a></li>
			<li><a href="/users/mypage.do">My page</a></li>
		</c:if>
	</ul>
</div>
