<%-- 
    Document   : home
    Created on : 2 mai 2018, 15:09:11
    Author     : gpetemoy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="./style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${sessionScope.name}'s TODO List</title>
    </head>
    <body id="todolistBody">
        <div id="inputs">
            <h1> Welcome <span id="username">${sessionScope.name}</span>!</h1>
            <h2>
                Here is your private TO DO LIST!<br>
                Feel free to add any sort of task to it.
            </h2>
            <form id="form2" action="todolist" method="POST">
                <input id="textFld" autofocus type="text" name="list">
                <input id="addBtn" type="submit" value="ADD">
            </form>
        </div>
        <ul>
        <li id="todolistTitle">TO DO:</li>
            <c:forEach items="${sessionScope.list}" var="element">
                <li><input type="checkbox">${element}</li>
            </c:forEach>
        </ul>
    </body>
</html>
