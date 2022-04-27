<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Finding a book</title>
</head>
    <body>
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
        <br>
        <a href="/">Back to main menu</a>
    </body>
</html>
