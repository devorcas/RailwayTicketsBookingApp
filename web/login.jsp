

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="label.title" bundle="${rb}"/></title>
    </head>
    <body>
        <div align="center">
            <h1><fmt:message key="msg.user.greeting" bundle="${rb}"/></h1>
            <form name="login" action="./Controller" method="POST">
                <table border="0">
                    <input type ="hidden" name="command" value="login"/>
                    <tbody>
                        <tr>
                            <td><fmt:message key="label.login" bundle="${rb}"/>:</td>
                            <td><input type="text" name="email" value="" /></td>
                        </tr>
                        <tr>
                            <td><fmt:message key="label.password" bundle="${rb}"/>:</td>
                            <td><input type="password" name="password" value="" /></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="reset" value="<fmt:message key="label.clear" bundle="${rb}" />" name="clear" />
                            </td>
                            <td>
                                <input type="submit" value="<fmt:message key="label.login" bundle="${rb}"/>" name="submit" />
                            </td>

                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                ${errorLoginPassMessage} <br/>
                                ${wrongAction}<br/>
                                ${nullPage}<br/>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form>
        </div>
    </body>
</html>
