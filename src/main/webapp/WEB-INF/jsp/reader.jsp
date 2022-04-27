<%--
  Created by IntelliJ IDEA.
  User: beatka
  Date: 24/04/2022
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Finding a reader</title>
    </head>
    <body>
        <table border="1">
            <caption>Reader</caption>
            <tr>
                <th>reader id</th>
                <th>first name</th>
                <th>last name</th>
                <th>address</th>
                <th>telephone number</th>
                <th>registration date</th>
                <th>resignation date</th>
            </tr>
            <tr>
                <td>${reader.readerId}</td>
                <td>${reader.firstName}</td>
                <td>${reader.lastName}</td>
                <td>${reader.address}</td>
                <td>${reader.telephoneNumber}</td>
                <td>${reader.registrationDate}</td>
                <td>${reader.resignationDate}</td>
            </tr>
        </table>
        <br>
        <form action="/reader/resign" method="post">
            <label>
                <br>
                <input type="hidden" name="readerId" value=${reader.readerId}>
            </label>
            <button type="submit">Register resignation</button>
        </form>
        <br>
        <a href="/">Back to main menu</a>
    </body>
</html>