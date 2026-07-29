<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="model.User,model.Mutter,java.util.List" %>
<%
    User user = (User) session.getAttribute("loginUser");
    List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
    String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>どこつぶメイン</title>
</head>
<body>
    <h1>どこつぶメイン</h1>
    <p><%= user.getName() %>さんログイン中</p>
    <a href="Logout">ログアウト</a>
    <p><a href="Main">更新</a></p>
    <form action="Main" method="post">
        <input type="text" name="text" size="50">
        <br>
        <input type="submit" value="つぶやく">
    </form>
    <% if (errorMsg != null) { %>
        <p style="color: red;"><%= errorMsg %></p>  
    <% } %>
    <% for (Mutter mutter : mutterList) { %>
        <p><%= mutter.getUserName() %>: <%= mutter.getText() %></p>
    <% } %>
</body>
</html>