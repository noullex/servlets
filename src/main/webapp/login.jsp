<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1 align="center">NC 2016-1017 JSP example</h1>
        <form action = "${pageContext.request.contextPath}/login" method = "post">
            <table border = "0" align="center">
                <tr>
                    <td><b>Login</b></td>
                    <td><input type = "text" name = "parameter_lgn"
                               placeholder="enter login here" size = "30"/></td>
                </tr>
                <tr>
                    <td><b>Password</b></td>
                    <td><input type = "password" name = "parameter_pwd"
                               placeholder="enter password here" size = "30"/></td>
                </tr>
                <tr>
                    <td align="center" colspan = "2"><input type = "submit" name="button" value = "sign in"/></td>
                </tr>
                <tr>
                    <td align="center" colspan = "2"><a href="${pageContext.request.contextPath}/registration.jsp">sign up</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
