
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="label.registration.form" bundle="${rb}" /></title>
    </head>
    <body>
        <div align="center">
        <h1><fmt:message key="msg.contact.info" bundle="${rb}" /></h1><br/>
        <form name="command" value="register" action="./Controller" method="POST">
            <input type="hidden" name="command" value="register">
            <table border="0">
                <tbody>
                    <tr>
                        <td><fmt:message key="label.email" bundle="${rb}" />:</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.name" bundle="${rb}" />:</td>
                        <td><input type="text" name="name" value="" /></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.surname" bundle="${rb}" />:</td>
                        <td><input type="text" name="surname" value="" /></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.phone" bundle="${rb}" />:</td>
                        <td><input type="text" name="phone" value="" /></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="label.password" bundle="${rb}" />:</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="<fmt:message key="label.clear" bundle="${rb}" />" name="reset" /></td>
                        <td><input type="submit" value="<fmt:message key="label.submit" bundle="${rb}" />" name="submit" /></td>
                    </tr>
                    <td></td>
                        <td>
                            ${errorLoginPassMessage} <br/>
                            ${wrongAction}<br/>
                            ${nullPage}<br/>
                        </td>
                </tbody>
            </table>
        </form>
        </div>
    </body>
</html>
