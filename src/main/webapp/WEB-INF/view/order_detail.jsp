<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 29.08.2022
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create order</title>
</head>
<body>
<h3>Enter order details</h3>
<form:form action="save_order" modelAttribute="customerOrder">
    <form:hidden path="id"></form:hidden>
    <table>
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><form:input path="address"></form:input></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><form:input path="description"></form:input></td>
        </tr>
        <tr>
            <td>Cost</td>
            <td><form:input path="cost"></form:input></td>
        </tr>
    </table>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
