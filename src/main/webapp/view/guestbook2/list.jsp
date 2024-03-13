<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방 명 록 </title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 600px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 600px; margin:auto; text-align: center;}
</style>
</head>
<body>
	<div>
		<h2> 방 명 록 </h2>
		<hr>
					<!-- 주소 뒤에 ? 붙여서 이름과 값을 가지고 가자 -->
		<p>[<a href="/02_login/Guest2?cmd=write">방명록 쓰기</a>]</p>
		<table>
			<thead>
				<tr style="background-color: #99ccff"><th>번호</th><th>작성자</th><th>제목</th><th>작성일</th></tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list}">
						<tr><td colspan="4"><h3>원하는 정보가 존재하지 않습니다.</h3></td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="k" items="${list }">
							<tr>
								<td>${k.idx}</td>
								<td>${k.name}</td>
											<!-- 가져가야할 파라미터는 주소뒤에 ? 붙여서 가져오자 (여러개 & ) -->
								<td>[<a href="/02_login/Guest2?cmd=onelist&idx=${k.idx}">${k.subject}</a>]</td>
								<td>${k.regdate.substring(0,10)}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>





