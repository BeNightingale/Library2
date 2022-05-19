<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Finding a book</title>
</head>
    <body style="background-color: lightgray; color: black">
        <table border="1">
            <caption>Book</caption>
            <tr>
                <th>book id</th>
                <th>title</th>
                <th>author</th>
                <th>isbn</th>
                <th>is borrowed</th>
            </tr>
            <tr>
                <td>${book.bookId}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>${book.borrowed}</td>
            </tr>
        </table>
        <br>
        <form action="/book/delete" method="post">
            <label>
                <br>
                <input type="hidden" name="id" value=${book.bookId}>
            </label>
            <button type="submit">Delete this book</button>
        </form>

        <form action="/book/return" method="post">
            <br>
            <c:choose>
                <c:when test="${book.isBorrowed()==true}">
                    <label>
                        <input type="hidden" name="id" value=${book.bookId}>
                        <button type="submit">Return this book</button>
                    </label>
                </c:when>
            </c:choose>
        </form>
        <form action="/loan/add" method="post">
            <br>
            <c:choose>
                <c:when test="${!book.isBorrowed()==true}">
                <label>
                    <input type="hidden" name="bookId" value=${book.bookId}>
                    <a>Input borrower's id:</a>
                    <input type="number" name="readerId">
                    <button type="submit">Loan this book</button>
                    <br>
                </label>
                </c:when>
            </c:choose>
            <br>
        </form>
        <form action="/book/update" method="get">
            <label>
                <input type="hidden" name="bookId" value=${book.bookId}>
            </label>
            <button type="submit">Update this book data</button>
        </form>
        <br>
        <a href="/">Back to main menu</a>
    </body>
</html>
