<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title><spring:message text="Registration Form"></spring:message></title>
</head>
<body>
    <H1>
        <spring:message text="Registration Form"></spring:message>
    </H1>
	<form:form action="registration" method="POST" commandName="userForm">
		<tr>
			<td>
				<label>
					<spring:message text='Username:'></spring:message>
				</label>
			</td>
			<td>
				<form:input path="userName" value="" />
			</td>
			<form:errors path="userName" element="div" />
		</tr>
		<tr>
			<td>
				<label>
					<spring:message text="Password:"></spring:message>
				</label>
			</td>
			<td>
				<form:input path="password" value="" type="password" />
			</td>
			<form:errors path="password" element="div" />
		</tr>
	<button type="submit"><spring:message text="Submit"></spring:message>
	</button>
	</form:form>
    <a href="<c:url value="/" />">
        <spring:message text="Back to Home"></spring:message>
    </a>
</body>
</html>