<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
    <head>
        <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        <header>
            <h1>Title : ${title}</h1>
        </header>
        <section>
            <h1>Message : ${message}</h1>
        </section>
        <div><a href="desktop">Log in</a></div>
        <div><a href="registration">Sign up</a></div>
    </body>
</html>