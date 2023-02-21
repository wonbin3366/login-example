<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>

        <body>
            <h1>회원가입 페이지</h1>
            <br />

            <form action="/join" method="post">
                <div>
                    <input type="text" name="username" placeholder="Enter username" id="username">
                </div>

                <div>
                    <input type="password" name="password" placeholder="Enter password" id="password">
                </div>

                <div>
                    <input type="email" name="email" placeholder="Enter email" id="email">
                </div>
                <button type="submit" class="btn btn-warning">회원가입</button>
            </form>


        </body>

        </html>