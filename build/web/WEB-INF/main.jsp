

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="label.title" bundle="${rb}"/></title>
    </head>

    <body>
        <div align="center">
            <c:choose>
                <c:when test="${user.isActivated}">
                    <h4><fmt:message key="msg.logged.greeting" bundle="${rb}"/></h4>
                    <hr/>
                    <fmt:message key="msg.user.name" bundle="${rb}"/> : ${user.name}
                    <hr/>
                    <fmt:message key="msg.choose.parameters" bundle="${rb}"/>
                    <form name="find_routes" action="./Controller" method="POST">

                        <table border="0">
                            <thead>
                                <tr>
                                    <th><fmt:message key="label.departure.station" bundle="${rb}"/></th>
                                    <th><fmt:message key="label.destination.station" bundle="${rb}"/></th>
                                    <th><fmt:message key="label.from.time" bundle="${rb}"/></th>
                                    <th><fmt:message key="label.departure.date.format" bundle="${rb}"/></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="text" name="depatureSt"  /></td>
                                    <td><input type="text" name="destinationSt"  /></td>
                                    <td><input type="text" name="time"  /></td>
                                    <td><input type="text" name="depatureDate"  /></td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="submit" value="find_routes" name="command" />
                    </form>
                    <form action=".\Controller" method="POST">

                        <c:choose>
                            <c:when test="${not empty foundRoutes}">
                                <hr/>
                                <fmt:message key="msg.found.trains" bundle="${rb}"/> : ${depatureDate}"
                                <hr/>
                                <table border="0">
                                    <thead>
                                        <tr>
                                            <th><fmt:message key="label.train" bundle="${rb}" /></th>
                                            <th><fmt:message key="label.departure.station" bundle="${rb}" /></th>
                                            <th><fmt:message key="label.destination.station" bundle="${rb}" /></th>
                                            <th><fmt:message key="label.departure.time" bundle="${rb}" /></th>
                                            <th><fmt:message key="label.destination.time" bundle="${rb}" /></th>
                                            <th><fmt:message key="label.berth" bundle="${rb}"/></th>
                                            <th><fmt:message key="label.coupe" bundle="${rb}"/></th>
                                            <th><fmt:message key="label.suit" bundle="${rb}"/></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="foundRoute" items="${foundRoutes}">
                                            <tr>
                                                <td><c:out value="${foundRoute.id}"/></td>
                                                <td><c:out value="${foundRoute.departureStation}"/></td>
                                                <td><c:out value="${foundRoute.destinationStation}"/></td>
                                                <td><c:out value="${foundRoute.departureTime}"/></td>
                                                <td><c:out value="${foundRoute.destinationTime}"/></td>
                                                <td><input type="submit" value="${foundRoute.berthPlaces}" name="berth${foundRoute.id}" /></td>
                                                <td><input type="submit" value="${foundRoute.coupePlaces}" name="coupe${foundRoute.id}" /></td>
                                                <td><input type="submit" value="${foundRoute.suitPlaces}" name="suit${foundRoute.id}" /></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                        <input type="hidden" name="command" value="create_invoice" />
                    </form>
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
