
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./header.jsp" %>
<fmt:setBundle basename="resources.config" var="cf"/>
<c:set var="userType" value="guest" scope="session"/>
<!DOCTYPE html>
<html>
    <head>

        <title><fmt:message key="label.title" bundle="${rb}"/></title>
    </head>
    <body>
        <div align="center">
            <h1><fmt:message key="label.welcome" bundle="${rb}"/></h1>
            <table border="0">
                <tbody>
                <td>
                    <form action="<fmt:message bundle="${cf}" key="path.page.login"/>" method="POST">
                        <input type="submit" value="<fmt:message key="label.login" bundle="${rb}"/>" name="login_button" />
                    </form>
                </td>
                <td>
                    <form action="<fmt:message bundle="${cf}" key="path.page.register"/>" method="POST">
                        <input type="submit" value="<fmt:message key="label.register" bundle="${rb}"/> " name="login_button" />
                    </form>
                </td>
                </tbody>
            </table>
        </div>
    </body>
</html>
