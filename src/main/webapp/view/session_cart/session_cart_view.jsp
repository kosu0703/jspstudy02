<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 장바구니는 리스트에 있기때문에 for 문 사용을 위해 태그라이브러리 필요 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<h2>장바구니보기</h2>
		<h3>
			<!-- 장바구니에 정보가 있을수도 없을수도 -->
			<c:choose>
				<c:when test="${empty list}">
					<span>장바구니가 비어있습니다.</span>
				</c:when>
				<c:otherwise>
					<c:forEach var="k" items="${list}">
						<li>${k}</li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</h3>

	</body>
</html>