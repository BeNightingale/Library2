<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <html>
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Library</title>
            <base href="${pageContext.request.contextPath}">
            <link rel="stylesheet" href="/css/root.css" type="text/css">
            <link href="https://fonts.googleapis.com/css2?family=Vollkorn&display=swap" rel="stylesheet">
        </head>
        <body>
            <article>
                <h3>What would you like to do?</h3>
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
                <br>
                <a href="/logout">logout</a>
            </article>
        </body>
    </html>
