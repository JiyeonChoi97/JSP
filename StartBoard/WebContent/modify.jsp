<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
</head>
<body>
<form action="./modifySave.do"  method="post">
<input type="hidden" name="clno" value="${bdto.bno }">
<table border="1">
		<tr>
			<td colspan="2" style="text-align: center;">수정 페이지</td>
		</tr>
		<tr>
			<td>글 번호</td>
			<td>${bdto.bno }</td>
		</tr>
		<tr>
			<td>작성 날짜</td>
			<td>${bdto.regdate }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${bdto.title }"></td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td><input type="text" name="author" value="${bdto.author }"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols="20" rows="5" name="content">${bdto.content }</textarea></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="email" value="${bdto.email }"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="수정하기">	
				<input type="reset" value="초기화">	
			</td>
		</tr>
	</table>
</form>
</body>
</html>