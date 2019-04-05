<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트</h1>
	<p>입력한 정보 내역입니다.</p>
	<c:forEach items="${list}" var="vo">
	<table border="1" width="300">
		<tr>
			<td>Last name:</td>
			<td>${vo.lastName}</td>
		</tr>
		<tr>
			<td>First name:</td>
			<td>${vo.firstName}</td>
		</tr>
		<tr>
			<td>Email address:</td>
			<td>${vo.email}</td>
		</tr>
	</table>
	<br/>
	</c:forEach>
	<br/>
	<a href="http://localhost:8088/emailbook3/writeform">추가메일 등록</a>
</body>
</html>