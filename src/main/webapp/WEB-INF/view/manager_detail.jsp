<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 31.08.2022
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager detail</title>
</head>
<body>
<h1 style="color: dimgrey; text-align: center">MyCRM</h1><br>
<h2 style="text-align: center">Manager's list</h2>

<form:form action="save_manager" modelAttribute="manager">
    <form:hidden path="id"></form:hidden>
    <table>
        <tbody>
        <tr><td>Name</td><td><form:input path="name"></form:input></td></tr>
        <tr><td>Sur Name</td><td><form:input path="surName"></form:input></td></tr>
        <tr><td>Salary</td><td><form:input path="salary"></form:input></td></tr>
        </tbody>
    </table>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
