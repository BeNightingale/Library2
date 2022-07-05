<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Updating book data</title>
        <link rel="stylesheet" href="/css/operation.css" type="text/css">
    </head>
    <body>
        <form action="/book/update/data" method="post">
            <label>
                <input type="hidden" name="bookId" value=${book.bookId}>
            </label>
            <label>Insert fixed book data:
                <p>Title:</p>
                <input type="text" name="title" value="${book.title}">
                <p>Author:</p>
                <input type="text" name="author" value="${book.author}">
                <p>Isbn:</p>
                <input type="number" name="isbn" value="${book.isbn}">
            </label>
            <br>
            <br>
            <button type="submit">Update this book data</button>
        </form>
        <br>
        <a href="/">Back to main menu</a>
    </body>
</html>

