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
		<thead>
			<tr>
				<th>게시판 번호</th>
				<th>글 제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${bList }" var="bdto">
			<tr>
				<td>${bdto.bno }</td>
				<td style="width: 200px;"><a href="./detail.do?clno=${bdto.bno }">${bdto.title }</a></td>
				<td style="width: 200px;">${bdto.author }</td>
				<td style="width: 200px;">${bdto.regdate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>