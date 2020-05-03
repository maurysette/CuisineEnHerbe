<%-- 
    Document   : registerTemplate
    Created on : 23 avr. 2020, 16:44:59
    Author     : bst
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:forTokens items="${param.cssFiles}" delims="|" var="cssFiles">
            <link rel="stylesheet" href="<c:url value="/rsc/css/${cssFiles}.css"/>">
        </c:forTokens>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>
        <jsp:include page="registerContent.jsp"/>
        <jsp:include page="/WEB-INF/template/footer.jsp"/>
    </body>
</html>
