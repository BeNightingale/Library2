<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Adding new loan</title>
</head>
<body>
<form action="/loan/add" method="post">
  <p>Insert loan data:</p>
  <label>
    <p>Borrowed book id:</p>
    <input type="number" name="bookId">
    <p>Reader id:</p>
    <input type="number" name="readerId">
  </label>
  <br>
  <button type="submit">Add this loan</button>
</form>
</body>
</html>



