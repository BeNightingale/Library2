
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Form - getting a book</title>
        <link rel="stylesheet" href="/css/operation.css" type="text/css">
    </head>
    <body>
        <form action="/book" method="get">
            <p>Search by book id:</p>
            <label>
                <input type="number" name="id">
            </label>
            <button type="submit">Submit</button>
        </form>
        <form action="/book/find/title" method="get">
            <p>Search by book title:</p>
            <label>
                <input type="text" name="title">
            </label>
            <button type="submit">Submit</button>
        </form>
        <br>
        <a href="/">Back to main menu</a>
    </body>
</html>
