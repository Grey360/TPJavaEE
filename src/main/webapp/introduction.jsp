<%-- 
    Document   : newjsp
    Created on : 2 mai 2018, 14:26:39
    Author     : gpetemoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="introduce" method="POST">
            <input name="name" placeholder="Your username...">
            <input type="submit" value="Se présenter">
        </form>
    </body>
</html>
