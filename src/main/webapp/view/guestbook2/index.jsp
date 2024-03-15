<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<form action="${pageContext.request.contextPath}/Guest2" method="post">
			<input type="submit" value="guestbook2">
			<input type="hidden" name="cmd" value="list">
		</form>
		
	</body>
</html>