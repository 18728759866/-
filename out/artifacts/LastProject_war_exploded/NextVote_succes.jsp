<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/9/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>进入下一轮投票成功</title>
    <style>
        body{
            background-size: 1540px 720px;
        }
        #x1{
            text-align: center;
            color: lightseagreen;
        }
        #x2{
            text-align: center;
            padding-top: 30px;
            color: lightseagreen;
        }
    </style>
</head>
<body background="static/img/x24.jpg">
<h1 id="x1">进入下一轮投票成功，评委可以重新投票</h1>
<h1 id="x2">2秒返回主界面</h1>
<%
    response.setHeader("refresh", "2 ;url=http://localhost:8080/LastProject_war/login_succes.jsp");   //在当前页面停顿2秒，然后跳转到登录界面
%>
</body>
</html>
