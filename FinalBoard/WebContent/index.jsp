<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${param.pg==null || param.pg=='' }">
		<c:set var="printPage" value="30_Main.jsp" />
	</c:when>
	<c:when test="${param.pg.equals('welcome') }">
		<c:set var="printPage" value="member/welcome.jsp" />
	</c:when>
	<c:when test="${param.pg.equals('pList') }">
		<c:set var="printPage" value="product/list.jsp" />
	</c:when>
	<c:when test="${param.pg.equals('pWrite') }">
		<c:set var="printPage" value="product/write.jsp" />
	</c:when>
	<c:when test="${param.pg.equals('pDetail') }">
		<c:set var="printPage" value="product/detail.jsp" />
	</c:when>
	<c:when test="${param.pg.equals('pModify') }">
		<c:set var="printPage" value="product/modify.jsp" />
	</c:when>
</c:choose>

<jsp:include page="00_header.jsp"></jsp:include>
<jsp:include page="10_topbar.jsp"></jsp:include>
<jsp:include page="20_nav.jsp"></jsp:include>
<jsp:include page="${printPage }"></jsp:include>
<jsp:include page="90_footer.jsp"></jsp:include>