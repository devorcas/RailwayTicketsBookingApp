

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="ctg" uri="customtags"%>
<fmt:setLocale value="en_US" scope="session"/>
<fmt:setBundle basename="resources.pagecontent" var="rb"/>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
    <head> Time & Locale info</head>
    <body>
        <ctg:info-time/>
    </body>
</html>