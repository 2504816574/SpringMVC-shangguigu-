<%--
  Created by IntelliJ IDEA.
  User: 25048
  Date: 2020/12/23
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>REST</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/testREST/1001">测试GET</a>
        <br>
        <form action="${pageContext.request.contextPath}/testREST" method="post">
            <input type="submit" value="Post">
        </form>
        <form action="${pageContext.request.contextPath}/testREST" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="PUT">
        </form>
        <form action="${pageContext.request.contextPath}/testREST/1001" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="DELETE">
        </form>
    </body>
</html>
