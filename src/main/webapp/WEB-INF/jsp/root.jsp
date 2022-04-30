<%--
  Created by IntelliJ IDEA.
  User: beatka
  Date: 22/04/2022
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
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
                <a href="ścieżka">check if the book is available</a>
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
                <a href="ścieżka">register returning a book</a>
            </div>
        </body>
    </html>
