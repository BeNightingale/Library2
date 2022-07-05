<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Adding new reader</title>
        <link rel="stylesheet" href="/css/operation.css" type="text/css">
    </head>
    <body>
        <form action="/reader/add" method="post">
            <p>Insert reader data:</p>
            <label>
                <p>First name:</p>
                <input type="text" name="firstName">
                <p>Last name:</p>
                <input type="text" name="lastName">
                <p>Address:</p>
                <input type="text" name="address">
                <p>Telephone number:</p>
                <input type="text" name="telephoneNumber">
            </label>
            <br>
            <br>
            <button type="submit">Add this reader</button>
        </form>
        <br>
        <a href="/">Back to main menu</a>
    </body>
</html>

