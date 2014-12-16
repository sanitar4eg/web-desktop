<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Widgets</title>
</head>
<body>
	<table border="0">
		<tr>
			<td colspan="2" align="center"><h2>Widget Updated!</h2></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<h3>Your current widgets</h3>
			</td>
		</tr>
		<tr>
			<td>${userWidgets.getWidgetName()}</td>
		</tr>
	</table>
	<a href="<c:url value="/desktop" />"> Back to Dsktop </a>

</body>
</html>