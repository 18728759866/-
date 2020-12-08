<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/21
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
    <style>
        body{
            background-size: 1540px 720px;

        }
        #x1{
            background-color: lightseagreen;
            border: none;
            color: #fff;
            width: 100px;
            height: 40px;
            margin-left: 700px;
        }
        #x2{
            background-color: lightseagreen;
            border: none;
            color: #fff;
            width: 100px;
            height: 40px;
            margin-left: 700px;
            margin-top: 50px;
        }
    </style>
</head>
<body background="static/img/x9.jpg">

       <form>
           <input id="x1" type="submit" value="评委投票" onclick = window.open("http://localhost:8080/LastProject_war/judgevote.jsp") >
           <br>
           <input id="x2" type="submit" value="返回主界面" onclick = window.open("http://localhost:8080/LastProject_war/login_succes.jsp")>
       </form>
</body>
</html>
