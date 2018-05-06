<%-- 
    Document   : home
    Created on : 2 mai 2018, 15:09:11
    Author     : gpetemoy
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/png" href="world-wide-web.png">
        <title>${name}'s TODO List</title>
    </head>
    <body id="todolistBody">
        <div id="inputs">
            <h1> Welcome <span id="username">${name}</span>!</h1>
            <h2>
                Here is your private TO DO LIST!<br>
                Feel free to add any sort of task to it.
            </h2>
            <form id="form2" action="todolist" method="POST">
                <input type="text" name="name" value="${name}" style="display: none;">
                <input id="textFld" autofocus type="text" name="list">
                <input id="addBtn" type="submit" value="ADD">
            </form>
        </div>
        <ul>
        <li id="todolistTitle">TO DO:</li>
            <c:forEach items="${list}" var="element">
                <li><input type="checkbox">${element}</li>
            </c:forEach>
        </ul>
    </body>
</html>
