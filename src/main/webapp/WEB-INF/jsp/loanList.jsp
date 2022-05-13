<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Loan search results</title>
</head>
<body style="background-color: darkseagreen; color: black">
<table border="1">
    <caption>Loan search results</caption>
    <tr>
        <th>loan id</th>
        <th>book id</th>
        <th>reader id</th>
        <th>loan date</th>
        <th>return date</th>
    </tr>
    <c:forEach var="loan" items="${loans}">
        <tr>
            <td><a href="/loan?id=${loan.loanId}">${loan.loanId}</a></td>
            <td><a href="/book?id=${loan.book.bookId}">${loan.book.bookId}</a></td>
            <td><a href="/reader?id=${loan.reader.readerId}">${loan.reader.readerId}</a></td>
            <td><a href="/loan?id=${loan.loanId}">${loan.loanDate}</a></td>
            <td><a href="/loan?id=${loan.loanId}">${loan.returnDate}</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/">Back to main menu</a>
</body>
</html>

