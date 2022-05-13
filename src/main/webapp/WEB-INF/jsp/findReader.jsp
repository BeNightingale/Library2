<%--
  Created by IntelliJ IDEA.
  User: beatka
  Date: 24/04/2022
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Form - getting a reader</title>
    </head>
    <body>
    <form action="/reader" method="get">
        <p>Search by reader's id:</p>
        <label>
            <input type="number" name ="id">
        </label>
        <button type="submit">Submit</button>
    </form>
    <form action="/reader/find/name" method="get">
        <p>Search by reader's full name:</p>
        <label>
            <input type="text" name="firstName">
            <input type="text" name="lastName">
        </label>
        <button type="submit">Submit</button>
    </form>
    </body>
</html>
