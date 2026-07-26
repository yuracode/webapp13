<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>とこつぶ</title>
    </head>

    <body>
        <h1>とこつぶへようこそ</h1>
        <form action="Login" method="post">
            <label for="username">ユーザー名:</label>
            <input type="text" id="username" name="name" ><br><br>
            <label for="password">パスワード:</label>
            <input type="password" id="password" name="pass" ><br><br>
            <input type="submit" value="ログイン">
        </form>
    </body>

    </html>