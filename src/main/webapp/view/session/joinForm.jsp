<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
	<form action="/02_login/MyController" method="post" autocomplete="off">
		<p> **ID : <input type="text" name="id" required > </p>
		<p> **PWD : <input type="password" name="pwd" required > </p>
		<p> **Name : <input type="text" name="name" required > </p>
		<p> **Email : <input type="text" name="email" required > </p>
		<p> Addr : <input type="text" name="addr"  > </p>
		<p> Phone : <input type="text" name="phone" > </p>
		<input type="hidden" name="cmd" value="join_ok" >
		<input type="submit" value="회원가입" >
		<input type="reset" value="취소" >
	</form>
</body>
</html>