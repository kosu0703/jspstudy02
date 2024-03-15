<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">
	function del_go(f) {
		//	가져온 비밀번호로 검사
		const pwd = "${pwd}";
		const pwd2 = f.pwd.value;
		if(pwd === pwd2){
			const chk = confirm("정말 삭제하시겠습니까?");
			if (chk) {
				f.action = "${pageContext.request.contextPath}/Guest2";
				f.submit();
			}else {
				//	history 오고가고한 경로
				//	-1 뒤로가기 , 1 앞으로가기
				history.go(-1);
			}
		}else {
			alert("비밀번호가 틀렸습니다.");
			f.pwd.value = "";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>
<body>
	<div>
		<h2>방명록 : 삭제화면</h2>
		<hr />
		<p>[<a href="/02_login/Guest2?cmd=list">게시물 목록으로</a>]</p>
		<form method="post">
			<table>
				<tr align="left">
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="password" name="pwd" size ="20"/></td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="hidden" name="idx" value="${idx}">
							<input type="hidden" name="cmd" value="delete_ok">
							<input type="button" value="삭제" onclick="del_go(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>