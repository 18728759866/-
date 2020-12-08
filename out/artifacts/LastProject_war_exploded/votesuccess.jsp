<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/27
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投票成功</title>
    <style>
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
<body background="static/img/x2.jpg">
<h1 id="x1">投票成功</h1>
<h1 id="x2">2秒后进行实时展示</h1>
<%
    response.setHeader("refresh", "2 ;url=http://localhost:8080/LastProject_war/datashow.jsp");   //在当前页面停顿1秒，然后跳转到登录界面--
%>

</body>
</html>
