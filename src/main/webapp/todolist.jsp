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
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1> Hello ${sessionScope.name} </h1>
            <h2> Voici votre TODO List personnalisée! </h2>
            <form id="form" action="todolist" method="POST">
                <input type="text" name="list">
                <input type="submit" value="Ajouter">
            </form>
        </div>
        <ul>
            <c:forEach items="${sessionScope.list}" var="element">
                <li>${element}</li>
            </c:forEach>
        </ul>
    </body>
</html>
