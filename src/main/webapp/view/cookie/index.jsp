<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.form{display: inline-block;}
	div{
		width: 250px;
		height: 40px;
		padding: 20px;
		background : lightgray;
	}
</style>
</head>
<body>
	 <c:if test="${res == null && cookie.id.value == null }">
		<form action="/02_login/CookieController" method="post" class="form">
			<input type="submit" value="로그인">
			<input type="hidden" name="cmd" value="c_login">
		</form>
		<form action="/02_login/CookieController" method="post" class="form">
			<input type="submit" value="회원가입">
			<input type="hidden" name="cmd" value="c_join">
		</form>
	</c:if> 
	
	<c:if test="${res == 1 || cookie.id.value != null }">
		<span class="form"> ${cookie.id.value }님 환영합니다.</span>
		<form action="/02_login/CookieController" method="post" class="form">
			<input type="submit" value="로그아웃">
			<input type="hidden" name="cmd" value="c_logout">
		</form>
		<form action="/02_login/CookieController" method="post" class="form">
			<input type="submit" value="마이페이지">
			
			<%--  대신에 서버에서 쿠키에 id와 패스워드를 담았다. 
			<input type="hidden" name="id"  value="${bvo.id }" >
			<input type="hidden" name="pwd" value="${bvo.pwd }"> 
			--%>
			<input type="hidden" name="cmd" value="c_profile">
			
		</form>
	</c:if>
	
	<c:choose>
		<c:when test="${res2 != 1 || cookie.ad_close7.value != 7}">
			<div>
				<form action="/02_login/CookieController" method="post">
					<input type="submit" value="일주일동안 보이지 않기">
					<input type="hidden" name="cmd" value="ad_close7">
				</form>
				<form action="/02_login/CookieController" method="post">
					<input type="submit" value="닫기">
					<input type="hidden" name="cmd" value="ad_close">
				</form>
			</div>
		</c:when>
	</c:choose>
	
</body>
</html>