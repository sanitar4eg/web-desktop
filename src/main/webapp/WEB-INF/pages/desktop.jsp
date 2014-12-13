<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				Hello, ${user} 
			</h2>
	</c:if>
	
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
	            </tr>
				<c:forEach items="${journalList}" var="task">
					<tr>
					  <td><c:out value="${task.getName()}" /></td>
					  <td><c:out value="${task.getDescription()}" /></td>
					  <td><c:out value="${task.getMinderTime()}" /></td>
					  <td><c:out value="${task.getContacts()}" /></td>
					</tr>
				</c:forEach>
			</table>
	</c:if>

	<sec:authorize access="hasRole('USER')">
		<!-- For login user -->
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


	</sec:authorize>
</body>
</html>