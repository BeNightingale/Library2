<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Finding a reader</title>
    </head>
    <body style="background-color: lightgray; color: black">
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
        <table border="1">
            <caption>Not returned books:</caption>
            <tr>
                <th>loan date</th>
                <th>book id</th>
                <th>title</th>
                <th>author</th>
                <th>isbn</th>
            </tr>
            <c:forEach var="loan" items="${reader.notReturnedBooks}">
                <tr>
                    <td>${loan.loanDate}</td>
                    <td><a href="/book?id=${loan.book.bookId}">${loan.book.bookId}</a></td>
                    <td><a href="/book?id=${loan.book.bookId}">${loan.book.title}</a></td>
                    <td><a href="/book?id=${loan.book.bookId}">${loan.book.author}</a></td>
                    <td><a href="/book?id=${loan.book.bookId}">${loan.book.isbn}</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="/reader/resign" method="post">
            <c:choose>
                <c:when test="${reader.hasReturnedBooks()==true && reader.resignationDate == null}">
                    <label>
                        <br>
                        <input type="hidden" name="readerId" value=${reader.readerId}>
                    </label>
                    <button type="submit">Register resignation</button>
                </c:when>
            </c:choose>
        </form>
        <br>
        <form action="/reader/update" method="get">
            <label>
                <input type="hidden" name="readerId" value=${reader.readerId}>
            </label>
            <button type="submit">Update this reader data</button>
        </form>
        <br>
        <a href="/">Back to main menu</a>
    </body>
</html>