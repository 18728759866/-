<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/30
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>不能创建</title>
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
<body background="static/img/x19.jpg">

<h1 id="x1">你已经创建项目了，不能再次创建了，请您删除项目后再创建！</h1><br>
<h1 id="x2">2秒后返回主界面。。。</h1>
<%
    response.setHeader("refresh", "2 ;url=http://localhost:8080/LastProject_war/login_succes.jsp");   //在当前页面停顿1秒，然后跳转到登录界面
%>
</body>
</html>
