<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.myDiv {
  border: 2px outset red;
  background-color: lightblue;    
  text-align: center;
  margin-left:300px;
  margin-right:250px;
  
}
</style>
</head>
<body>
<div class="myDiv">
<%@include file="menu.jsp" %>
<h3>WELCOME TO STUDENT REGISTER PAGE</h3>
<form:form action="save" method="POST" modelAttribute="student">

<pre>
NAME  : <form:input path="stdName"/>
GENDER: 
  <form:radiobutton path="stdGen" value="Male"/> Male
  <form:radiobutton path="stdGen" value="Female"/> Female
PASSWORD: <form:password path="stdPwd"/>
COURSE  : <form:select path="stdCourse">
				<form:option value="">-SELECT-</form:option>
				<form:option value="Java">Java</form:option>
				<form:option value="Angular">Angular</form:option>
				<form:option value="dotNet">dotNet</form:option>
				<form:option value="PHP">PHP</form:option>
			</form:select>       
ADDRESS : <form:textarea path="stdAddr"/>
LANGUAGES:
        <form:checkbox path="stdLangs" value="ENG"/> ENG
        <form:checkbox path="stdLangs" value="HIN"/> HIN
        <form:checkbox path="stdLangs" value="TAM"/> TAM
        <form:checkbox path="stdLangs" value="TEL"/> TEL
		<input type="submit" value="Add Student">
</pre>
</form:form>
${message}
</div>
</body>
</html>