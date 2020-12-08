<%@ page import="com.gl.dao.impl.RespondentDaoImpl" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/22
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        body{
            background-size: 1540px 720px;
        }
    #x1{
        background-color: #39987c;
        border: none;
        color: #fff;
        width: 90px;
        height: 40px;
        margin-top: 20px;
    }
    #x2{
        background-color: #39987c;
        border: none;
        color: #fff;
        width: 90px;
        height: 40px;
        margin-top: 30px;
    }
    #x3{
        background-color: #39987c;
        border: none;
        color: #fff;
        width: 90px;
        height: 40px;
        margin-top: 20px;
    }
        #x4{
            font-size: 25px;
            color: white;
        }
        #x5{
            font-size: 25px;
            color: white;
        }
        #x6{
            font-size: 25px;
            color: white;
        }
    </style>
    <title>评委投票</title>
<%--    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
    <script type="text/javascript">
        <%
    List list = new RespondentDaoImpl().GetRespondent((String)request.getSession().getAttribute("projectID"));
    request.getSession().setAttribute("list1",list);
%>
    </script>
</head>
<body background="static/img/x21.jpg">

<center>

    <h3 id="x5">您的投票（单选框）</h3>

<c:forEach items="${sessionScope.list1}" var="list">
    <form action="http://localhost:8080/LastProject_war/judgevote" method="post">
        <label id="x6">${list.name}: ${list.introduce}</label><input type="radio" name="username" value="${list.name}">
            <br>
            </c:forEach>
        <br>
        <span id="x4">${empty sessionScope.message3 ? "请投票" : sessionScope.message3}</span>
        <hr>
        <input type="submit" id="x1" value="投票">
</form>

<form action="http://localhost:8080/LastProject_war/abandonvote" method="post">
    <input type="submit" id="x2" value="弃票">
</form>
<input type="submit" id="x3" value="返回主界面" onclick = window.open("http://localhost:8080/LastProject_war/login_succes.jsp")>
</body>
</html>
