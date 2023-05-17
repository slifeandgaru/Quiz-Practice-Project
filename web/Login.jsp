<%-- 
    Document   : Login
    Created on : May 14, 2023, 8:33:37 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div>
                <form action="LoginController">
                    <h3>Login</h3>
                    <label for="account">Account</label>
                    <input type="text" name="account" placeholder="Account" id="account">
                    </<p></p>
                    <label for="password">Password</label>
                    <input type="password" name="pass" placeholder="Password" id="password">

                    <input type="submit" name="submit" value="Login"><br>
                    <p>Do not have an account yet ? <a href="SignUp.jsp">Sign up</a></p>

                </form>
            </div>

        </div>
    </body>
</html>
