<%-- 
    Document   : recipeTemplate
    Created on : 22 avr. 2020, 17:55:33
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
        <title>${param.websiteTitle}</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>
        <jsp:include page="recipeContent.jsp"/>
        <jsp:include page="/WEB-INF/template/footer.jsp"/>
    </body>
</html>
