<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 21.08.2022
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>MyCRM</title>
<head>
    <style type="text/css">
        TD {
            vertical-align: top;
        }

        #col1 {
            width: 33%;
            background-color: darkgrey;
        }

        #col2 {
            width: 33%;
            background-color: darkgrey;
        }

        #col3 {
            width: 33%;
            background-color: darkgrey;
        }
    </style>
</head>
<body>
<%--Заголовок выравниваем по центру--%>
<h1 style="color: dimgrey; text-align: center">MyCRM</h1><br>
<%--Кнопка добавления заказа--%>
<input type="button" value="+ NEW ORDER" ;
       onclick="window.location.href = 'new_order'">
<input type="button" value="MANAGERS" ;
       onclick="window.location.href = 'managers'">
<%--Создаем таблицу в црм--%>
<div style="display:flex; justify-content: center; flex-direction: column; width: 99%">

    <table>
        <tbody>
        <%--Три статуса заказа--%>

        <%--            First columt with new orders--%>

        <tr>
            <td id="col1"><h3 style="text-align: center">NEW ORDER'S</h3>  <br>

                <c:forEach var="customerOrderList1" items="${customerOrderList1}">
                    <div style="display: grid; grid-template-columns: 1fr max-content; grid-auto-flow: column; grid-column-gap: 5px">
                        <c:url var="updateButton" value="/edit_order">
                            <c:param name="orderID" value="${customerOrderList1.id}"></c:param>
                        </c:url>

                        <c:url var="updateStageUP" value="/updateStage">
                            <c:param name="orderID" value="${customerOrderList1.id}"></c:param>
                            <c:param name="stage" value="${1}"></c:param>
                        </c:url>

                        <input type="button" style="text-align: left; width: 100%" value=
                                "Order ID: ${customerOrderList1.id}
                            Address : ${customerOrderList1.address}
                            Cost : ${customerOrderList1.cost} RUB"
                               onclick="window.location.href = '${updateButton}'">

                        <input type="button" style="width:35px" value=">>"
                               onclick="window.location.href = '${updateStageUP}'">

                    </div>
                </c:forEach>
            </td>

            <%--            Second columt with in work orders--%>

            <td id="col2"><h3 style="text-align: center">IN WORK</h3><br>
                <c:forEach var="customerOrderList2" items="${customerOrderList2}">
                    <div style="display: grid; grid-template-columns: 1fr max-content; grid-auto-flow: column; grid-column-gap: 5px">

                        <c:url var="updateButton" value="/edit_order">
                            <c:param name="orderID" value="${customerOrderList2.id}"></c:param>
                        </c:url>

                        <c:url var="updateStageUP" value="/updateStage">
                            <c:param name="orderID" value="${customerOrderList2.id}"></c:param>
                            <c:param name="stage" value="${1}"></c:param>
                        </c:url>

                        <c:url var="updateStageDown" value="/updateStage">
                            <c:param name="orderID" value="${customerOrderList2.id}"></c:param>
                            <c:param name="stage" value="${-1}"></c:param>
                        </c:url>

                        <input type="button" style="width:35px" value="<<"
                               onclick="window.location.href = '${updateStageDown}'">

                        <input type="button" style="text-align: left; height: auto" value=
                                "Order ID: ${customerOrderList2.id}
                            Address : ${customerOrderList2.address}
                            Cost : ${customerOrderList2.cost} RUB"
                               onclick="window.location.href = '${updateButton}'">

                        <input type="button" style="width:35px" value=">>"
                               onclick="window.location.href = '${updateStageUP}'">

                    </div>
                </c:forEach>
            </td>
            <%--            Thirth columt with complited orders--%>
            <td id="col3"><h3 style="text-align: center">COMPLETED</h3><br>
                <c:forEach var="customerOrderList3" items="${customerOrderList3}">
                    <div style="display: grid; grid-template-columns: 1fr max-content; grid-auto-flow: column; grid-column-gap: 5px">
                        <c:url var="updateButton" value="/edit_order">
                            <c:param name="orderID" value="${customerOrderList3.id}"></c:param>
                        </c:url>

                        <c:url var="updateStageDown" value="/updateStage">
                            <c:param name="orderID" value="${customerOrderList3.id}"></c:param>
                            <c:param name="stage" value="${-1}"></c:param>
                        </c:url>

                        <input type="button" style="width:35px" value="<<"
                               onclick="window.location.href = '${updateStageDown}'">

                        <input type="button" style="text-align: left; width: 100%" value=
                                "Order ID: ${customerOrderList3.id}
                            Address : ${customerOrderList3.address}
                            Cost : ${customerOrderList3.cost} RUB"
                               onclick="window.location.href = '${updateButton}'">
                    </div>

                </c:forEach>
            </td>
        </tr>

        <%--Получаем список заказов--%>


        <%--                    <c:url var="updateButton" value="/edit_order">--%>
        <%--                        <c:param name="orderID" value="${orders.id}"></c:param>--%>
        <%--                    </c:url>--%>
        <%--                    <c:url var="updateStageUP" value="/updateStage">--%>
        <%--                        <c:param name="orderID" value="${orders.id}"></c:param>--%>
        <%--                        <c:param name="stage" value="${1}"></c:param>--%>
        <%--                    </c:url>--%>
        <%--                    <c:url var="updateStageDOWN" value="/updateStage">--%>
        <%--                        <c:param name="orderID" value="${orders.id}"></c:param>--%>
        <%--                        <c:param name="stage" value="${-1}"></c:param>--%>
        <%--                    </c:url>--%>
        <%--Инфо о заказе оформляем в кнопку, с заполнением по ширине столбца --%>
        <%--                    <td style="width: fit-content">--%>
        <%--                        <div style="display: grid; grid-template-columns: 1fr max-content; grid-auto-flow: column; grid-column-gap: 5px">--%>

        <%--                                &lt;%&ndash;                        Кнопка к предыдущей стадии&ndash;%&gt;--%>
        <%--                            <input type="button" value="<<"--%>
        <%--                                   onclick="window.location.href = '${updateStageDOWN}'">--%>

        <%--                                &lt;%&ndash;                        Кнопка заказа&ndash;%&gt;--%>
        <%--                            <input type="button" style="text-align: left" value=--%>
        <%--                                    "Order ID: ${orders.id}--%>
        <%--                            Address : ${orders.address}--%>
        <%--                            Cost : ${orders.cost} RUB--%>
        <%--                            Stage : ${orders.stage}"--%>
        <%--                                   onclick="window.location.href = '${updateButton}'">--%>

        <%--                                &lt;%&ndash;                        Кнопка к следующей стадии&ndash;%&gt;--%>
        <%--                            <input type="button" value=">>"--%>
        <%--                                   onclick="window.location.href = '${updateStageUP}'">--%>
        <%--                        </div>--%>


        </tbody>

    </table>
</div>
</body>
</html>
