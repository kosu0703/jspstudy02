<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/02_login/MyController" method="post" autocomplete="off">
	<fieldset style="width: 500px">
	  <legend style="font-weight: bold; font-size: 20px">로그인</legend>
 	  <label for="id">ID : <input type="text" id="id" name="id" ></label>
      <label for="pwd">PW : <input type="password" id="pwd" name="pwd"></label>
      <input type="hidden" name="cmd" value="login_ok">
      <input type="submit" value="로그인" >
    </fieldset>
</form>
</body>
</html>