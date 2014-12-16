<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Hello, ${user} 
		</h2>
	</c:if>
	<hr/> <!--   -->
	<form:form method="POST" modelAttribute="userEntity"
			action = "${pageContext.request.contextPath}/desktop/resultwidgets"
			>
		<table border="1" cellpadding="5">
		<tr>
			<td>User</td>
			<td>Widget</td>
		</tr>
		<c:forEach items="${widgetsList }" var="widget" varStatus="status">
			<tr>
				<td><form:checkbox path ="widgets" value = "${widget}"/></td>
				<td><c:out value="${widget.widgetName}" /></td>
			</tr>
		</c:forEach>
		</table>
		<input type="submit">
	</form:form>
	<hr/>
	
	<c:if test="${journalName != null}">
			<h2>
				Journal is ${journalName} 
			</h2>
			<table border="1" cellpadding="5">
				<caption><h3>List of tasks</h3></caption>
	            <tr>
	                <th>Name</th>
	                <th>Description</th>
	                <th>Minder Time</th>
	                <th>Contacts</th>
	                <th>Action</th>
	            </tr>
				<c:forEach items="${journalList}" var="task">
					<tr>
					  <td><c:out value="${task.getName()}" /></td>
					  <td><c:out value="${task.getDescription()}" /></td>
					  <td><c:out value="${task.getMinderTime()}" /></td>
					  <td><c:out value="${task.getContacts()}" /></td>
					 <!--   <td><input type="button" value="Delete" onclick="${journal.deleteTask(task.getName())}"/></td>
					 -->
					</tr>
				</c:forEach>
			</table>
	</c:if>

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />	
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			User : ${user} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
</body>
</html>