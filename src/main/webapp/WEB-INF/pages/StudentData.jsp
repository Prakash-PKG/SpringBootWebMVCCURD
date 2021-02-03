<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp" %>
<h3>Students Data Page</h3>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>GENDER</th>
		<!-- <th>PASSWORD</th> -->
		<th>COURSE</th>
		<th>ADDRESS</th>
		<th>LANGUAGES</th>
		<th>OPERATIONS</th>
	</tr>
	<c:forEach items="${page.getContent()}" var="ob">
		<tr>
			<td>${ob.stdId} </td>
			<td>${ob.stdName} </td>
			<td>${ob.stdGen} </td>
			<%-- <td>${ob.stdPwd} </td> --%>
			<td>${ob.stdCourse} </td>
			<td>${ob.stdAddr} </td>
			<td>${ob.stdLangs} </td>
			<td>
				<a href="delete?id=${ob.stdId}">DELETE</a> |
				<a href="edit?id=${ob.stdId}">EDIT</a>
			</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${!page.isFirst() }">
	<a href="?page=0">First</a>
</c:if>
<c:if test="${page.hasPrevious() }">
	<a href="?page=${page.getNumber()-1}">Previous</a>
</c:if>
<!-- for(int=0;i<totalPages;i++)-->
<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">
	<a href="?page=${i}">${i+1}</a> &nbsp;&nbsp;
</c:forEach>
<c:if test="${page.hasNext() }">
	<a href="?page=${page.getNumber()+1}">Next</a>
</c:if>
<c:if test="${!page.isLast() }">
	<a href="?page=${page.getTotalPages()-1}">Last</a>
</c:if>
</body>
</html>