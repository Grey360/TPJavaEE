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
        <link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body id="homeBody">
        <form id="form1" action="home" method="POST">
            <input id="homeInput" autofocus name="name" placeholder="Username...">
            <input id="homeBtn" type="submit" value="Check in">
        </form>
    </body>
</html>
