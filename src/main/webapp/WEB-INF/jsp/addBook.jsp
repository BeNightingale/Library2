<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Adding new book</title>
  <link rel="stylesheet" href="/css/operation.css" type="text/css">
</head>
<body>
<form action="/add/success" method="post">
  <p>Insert book data:</p>
  <label>
    <p>Title:</p>
    <input type="text" name="title">
    <p>Author:</p>
    <input type="text" name="author">
    <p>Isbn:</p>
    <input type="number" name="isbn">
  </label>
  <br>
  <br>
  <button type="submit">Add this book</button>
</form>
<br>
<a href="/">Back to main menu</a>
</body>
</html>
