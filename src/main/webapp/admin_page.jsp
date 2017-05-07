<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="central">This page can see only users with role ADMIN.</h1>
        <a href="${pageContext.request.contextPath}/user_page.jsp" align="center">Back to user page</a>
    </body>
</html>
