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
	<c:if test="${res == null }">
		<form action="/02_login/MyController" method="post" class="form">
			<input type="submit" value="로그인">
			<input type="hidden" name="cmd" value="login">
		</form>
		<form action="/02_login/MyController" method="post" class="form">
			<input type="submit" value="회원가입">
			<input type="hidden" name="cmd" value="join">
		</form>
	</c:if>
	<c:if test="${res == 1 }">
		<span class="form"> ${bvo.name}님 환영합니다.</span>
		<form action="/02_login/MyController" method="post" class="form">
			<input type="submit" value="마이페이지">
			<input type="hidden" name="id"  value="${bvo.id }" >
			<input type="hidden" name="pwd" value="${bvo.pwd }">
			<input type="hidden" name="cmd" value="profile">
			
		</form>
	</c:if>
</body>
</html>