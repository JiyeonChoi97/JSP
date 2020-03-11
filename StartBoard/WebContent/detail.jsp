<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>

<body>
<table border="1">
		<tr>
			<td colspan="2" style="text-align: center;">상세정보 페이지</td>
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
			<td>${bdto.title }</td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td>${bdto.author }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${bdto.content }</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td>${bdto.email }</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				
			</td>
		</tr>
	</table>
</body>
</html>