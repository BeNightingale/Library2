<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>Library</title>
        </head>
        <body>
            <p>What would you like to do?</p>
            <div>
                <p>Regarding a book:</p>
                <a href="/book/find">find a book</a><br>
                <a href="/book/add">add a book</a><br>
                <a href="book/find/all">show all books</a>
            </div>
            <div>
                <p>Regarding a reader:</p>
                <a href="/reader/find">find a reader</a><br>
                <a href="/reader/add">add a reader</a><br>
                <a href="reader/find/all">show all readers</a><br>
            </div>
            <div>
                <p>Regarding loans:</p>
                <a href="/loan/add">register lending a book</a><br>
                <a href="/loan/find/all">show all loans</a>
            </div>
        </body>
    </html>
