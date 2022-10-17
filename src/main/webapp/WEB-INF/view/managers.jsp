<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 31.08.2022
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager's</title>
</head>
<body>
<h1 style="color: dimgrey; text-align: center">MyCRM</h1><br>
<h2 style="text-align: center">Manager's list</h2>
<input type="button" value="+ NEW MANAGER" ; onclick="window.location.href = 'managers/manager_detail'">
<table>
    <tbody>
    <tr></tr>
    <tr>
        <th>Name</th><th>SurName</th><th>Salary</th><th>Order's</th>
    </tr>

    <c:forEach var="manager" items="${managers}">
        <th>${manager.name}</th><th>${manager.surName}</th><th>${manager.salary}</th><th></th>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
