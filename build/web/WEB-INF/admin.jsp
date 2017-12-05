
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="label.admin.panel" bundle="${rb}"/></title>
    </head>
    <body>
        <div align="center">
            <c:choose>
                <c:when test="${user.name == 'admin'}">


                    <h3><fmt:message key="label.admin.greeting" bundle="${rb}"/></h3>
                    <c:choose>
                        <c:when test="${not empty unconfirmedUsers}">
                            <form action="./Controller" name="update_users" method="post">
                                <input type ="hidden" name="command" value="update_users"/>
                                <table style="margin: auto">
                                    <tr class="odd">
                                        <th><fmt:message key="label.№" bundle="${rb}"/></th>
                                        <th><fmt:message key="label.email" bundle="${rb}"/></th>
                                        <th><fmt:message key="label.surname" bundle="${rb}"/></th>
                                        <th><fmt:message key="label.name" bundle="${rb}"/></th>
                                        <th><fmt:message key="label.phone" bundle="${rb}"/></th>
                                        <th><fmt:message key="label.do.action" bundle="${rb}"/></th>
                                    </tr>
                                    <c:forEach var="unconfUser" varStatus="loopStatus" items="${unconfirmedUsers}">
                                        <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
                                            <td><c:out value="${unconfUser.id}"/></td>
                                            <td><c:out value="${unconfUser.email}"/></td>
                                            <td><c:out value="${unconfUser.surname}"/></td>
                                            <td><c:out value="${unconfUser.name}"/></td>
                                            <td><c:out value="${unconfUser.phone}"/></td>
                                            <td>
                                                <select name="select_id${unconfUser.id}">
                                                    <option value="ignore"><fmt:message key="label.ignore" bundle="${rb}"/></option>
                                                    <option value="delete"><fmt:message key="label.delete" bundle="${rb}"/></option>
                                                    <option value="activate"><fmt:message key="label.activate" bundle="${rb}"/></option>
                                                </select>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>

                                <input type="submit" class="button-accept" name="update_users" value="<fmt:message key="label.submit" bundle="${rb}"/>" />
                            </form>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="msg.non.active.users" bundle="${rb}"/>
                        </c:otherwise>
                    </c:choose>
                    <br/><br/><br/>
                    <form name="logout" action="./Controller" method="POST">
                        <input type ="hidden" name="command" value="logout"/>
                        <input type="submit" value="<fmt:message key="label.logout" bundle="${rb}"/>"/>
                    </form>
                </c:when>
                <c:otherwise>
                    <a href="./index.jsp"><fmt:message key="msg.no.access" bundle="${rb}" /></a>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
