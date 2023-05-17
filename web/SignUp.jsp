<%-- 
    Document   : SignUp
    Created on : May 15, 2023, 7:31:59 AM
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
        <div class="signup-form ">
            <div>
                <div>Sign up today!</div>
                <div>
                    <form action="SignUpController">
                        <p>
                            <label>Account
                                <input type="text" name="account" placeholder="account" ><br>
                            </label>
                        </p>

                        <p>
                            <label>Password
                                <input type="text" name="password" placeholder="password" ><br>
                            </label>
                        </p>

                        <p>
                            <label>Email
                                <input type="email" name="email" placeholder="email" ><br>
                            </label>
                        </p>

                        <input type="submit" name="submit" value="Sign Up">
                        <!--                                    <button class="signup" type="submit" name="submit">Submit</button>-->
                        <!--                                    <a href="#" class="login">login</a>-->
                    </form>
                </div>
            </div>

        </div>
    </body>
</html>
