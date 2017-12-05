<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title.invoice" bundle="${rb}" /></title>
    </head>

    <body>
        <div align="center">
            <c:choose>
                <c:when test="${not empty user.name}">


                    <hr/><h1><fmt:message key="msg.prepared.invoice" bundle="${rb}" /></h1><hr/>
                    <table border="1">
                        <thead>
                            <tr>
                                <th><fmt:message key="label.train" bundle="${rb}" /></th>
                                <th><fmt:message key="label.departure.date" bundle="${rb}" /></th>
                                <th><fmt:message key="label.departure.station" bundle="${rb}" /></th>
                                <th><fmt:message key="label.destination.station" bundle="${rb}" /></th>
                                <th><fmt:message key="label.departure.time" bundle="${rb}" /></th>
                                <th><fmt:message key="label.destination.time" bundle="${rb}" /></th>
                                <th><fmt:message key="label.berth.type" bundle="${rb}" /></th>
                                <th><fmt:message key="label.cost" bundle="${rb}" /></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><c:out value="${orderedTrain.routeId}"/></td>
                                <td><c:out value="${depatureDate}"/></td>
                                <td><c:out value="${orderedRoute.departureStation}"/></td>
                                <td><c:out value="${orderedRoute.destinationStation}"/></td>
                                <td><c:out value="${orderedRoute.departureTime}"/></td>
                                <td><c:out value="${orderedRoute.destinationTime}"/></td>
                                <td><c:out value="${preparedInvoice.placeType}"/></td>
                                <td><c:out value="${preparedInvoice.price}"/></td>
                            </tr>
                        </tbody>
                    </table>

                    <br/><br/><br/>
                    <form name="logout" action="./Controller" method="POST">
                        <input type ="hidden" name="command" value="logout"/>
                        <input type="submit" value="<fmt:message key="label.logout" bundle="${rb}"/>"/>
                    </form>
                </c:when>
                <c:when test="${user.isActivated == false}">
                    <a href="./index.jsp"><fmt:message key="msg.not.activated" bundle="${rb}" /></a>
                </c:when>
                <c:otherwise>
                    <a href="./index.jsp"><fmt:message key="msg.no.access" bundle="${rb}" /></a>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
