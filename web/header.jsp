<%-- 
    Document   : header
    Created on : May 15, 2023, 8:07:30 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="entity.Users"%>

<% 
       Users currUser = (Users)request.getSession().getAttribute("currUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <% if(currUser==null){ %>
            <li>
                <a href="Login.jsp">Login</a>
            </li>
        <%}else{%>

     <li>
        <a href="LogoutController">Logout</a>
    </li>
    <%}%>
</body>
</html>
