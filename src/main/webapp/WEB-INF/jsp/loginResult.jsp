<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>どこつぶ</title>
</head>
<body>
    <% if(loginUser != null) { %>
        <h1>ログインに成功 しました</h1>
        <p>ようこそ、<%= loginUser.getName() %> さん！</p>
        <a href="Main">つぶやき投稿・閲覧へ</a>
    <% } else { %>
        <h1>ログインに失敗 しました</h1>
        <p>ユーザー名またはパスワードが間違っています。</p>
        <a href="index.jsp">トップへ</a>
    <% } %>
</body>
</html>