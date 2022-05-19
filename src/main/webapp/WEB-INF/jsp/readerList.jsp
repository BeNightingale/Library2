<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Reader search results</title>
    </head>
    <body style="background-color: lightgray; color: black">
        <table border="1">
            <caption>Reader search results</caption>
            <tr>
                <th>reader id</th>
                <th>first name</th>
                <th>last name</th>
                <th>address</th>
                <th>telephone number</th>
                <th>registration date</th>
                <th>resignation date</th>
            </tr>
            <c:forEach var="reader" items="${readers}">
            <tr>
                <td><a href="/reader?id=${reader.readerId}">${reader.readerId}</a></td>
                <td><a href="/reader?id=${reader.readerId}">${reader.firstName}</a></td>
                <td><a href="/reader?id=${reader.readerId}">${reader.lastName}</a></td>
                <td><a href="/reader?id=${reader.readerId}">${reader.address}</a></td>
                <td><a href="/reader?id=${reader.readerId}">${reader.telephoneNumber}</a></td>
                <td><a href="/reader?id=${reader.readerId}">${reader.registrationDate}</a></td>
                <td><a href="/reader?id=${reader.readerId}">${reader.resignationDate}</a></td>
            </tr>
            </c:forEach>
        </table>
            <br>
            <a href="/">Back to main menu</a>
    </body>
</html>
