<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1 align="center">Registration</h1>
        <form action = "${pageContext.request.contextPath}/registration" method = "post">
            <table border = "0" align="center">
                <tr>
                    <td><b>Login</b></td>
                    <td><input type = "text" name = "login"
                               placeholder="enter login here" size = "30"/></td>
                </tr>
                <tr>
                    <td><b>Password</b></td>
                    <td><input type = "password" name = "password"
                               placeholder="enter password here" size = "30"/></td>
                </tr>
                <tr>
                    <td align="center" colspan = "2"><input type = "submit" name="button" value = "registrate"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
