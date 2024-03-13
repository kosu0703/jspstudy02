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
</style>
</head>
<body>
				<!-- 로그인 실패 -->
	<c:if test="${svo == null }">
		<form action="/02_login/SessionController" method="post" class="form">
			<input type="submit" value="로그인">
			<input type="hidden" name="cmd" value="s_login">
		</form>
		<form action="/02_login/SessionController" method="post" class="form">
			<input type="submit" value="회원가입">
			<input type="hidden" name="cmd" value="s_join">
		</form>
	</c:if>
				<!-- 로그인 성공 -->
	<c:if test="${svo != null }">
		<span class="form"> ${svo.name}님 환영합니다.</span>
		<form action="/02_login/SessionController" method="post" class="form">
			<input type="submit" value="로그아웃">
			<input type="hidden" name="cmd" value="s_logout">
		</form>
		<form action="/02_login/SessionController" method="post" class="form">
			<input type="submit" value="마이페이지">
			<input type="hidden" name="cmd" value="s_profile">
		</form>
		
	</c:if>
</body>
</html>