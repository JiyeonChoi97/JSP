<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <h1>index.jsp</h1>
	<h1><a href="http://www.naver.com">Naver.com</a></h1>
	<h1><a href="./test.do?myName=Choi_Ji_Yeon">이름을 알려주세요~!~!</a></h1> -->

	<form action="./writeSave.do" method="post">
	<table border="1">
		<tr>
			<td colspan="2" style="text-align: center;">연습용 게시판 글쓰기</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" placeholder="제목을 입력하세요!" name="title" required></td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td><input type="text" placeholder="글쓴이를 입력하세요!" name="author" required></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols="40" rows="5" name="content"></textarea></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="email" placeholder="이메일을 입력하세요!" name="email"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="글작성 완료"">&nbsp;
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>
	</form>
	<a href="./list.do" style="font-size: 20px">리스트 가기</a>

</body>
</html>