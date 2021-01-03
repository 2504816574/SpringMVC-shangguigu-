<%--
  Created by IntelliJ IDEA.
  User: 25048
  Date: 2020/12/29
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/hello">hello</a>
        <form action="/test" method="post">
            name:<input type="text" name="username">
            <input type="submit">
        </form>
    </body>
</html>
