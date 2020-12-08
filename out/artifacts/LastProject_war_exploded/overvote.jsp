<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/28
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结束投票</title>
    <style>
        body{
            background-size: 1540px 720px;
        }
        #reset{
            margin-top: 150px;
            background-color: lightseagreen;
            border: none;
            color: #fff;
            width: 300px;
            height: 30px;
            margin-left: 600px;
        }
        #x5{
            color: purple;
            font-size: 30px;
            text-align: center;
            display: flex;
        }
        #x6{
            color: purple;
            font-size: 30px;
            text-align: center;
            display: flex;
        }
        #input{
            color: purple;
            font-size: 30px;
            display: flex;
            margin-top: 30px;
            margin-left: 650px;
        }
        #inputx{
            color: purple;
            font-size: 30px;
            display: flex;
            margin-top: 30px;
            margin-left: 650px;
        }
        #x3{
            display: flex;
        }
        #x4{
            display: flex;
        }
        #x1{
            color: purple;
            text-align: center;
            margin-top: 50px;
            font-size: 30px;
        }
    </style>
</head>
<body background="static/img/x18.jpg">

<c:if test="${sessionScope.scorename !=null}">
    <div id="x3">
        <label id="inputx">最高分为：</label><p id="x5">${sessionScope.scoremax}</p>
    </div>

    <br>
    <div id="x4">
        <label id="input">胜出者为：</label><p id="x6">${sessionScope.scorename}</p>
    </div>

</c:if>
<c:if test="${sessionScope.scorename ==null}">
    <h1 id="x1">无评委投票，均为0分</h1>

</c:if>
<input type="submit" id="reset" value="返回主界面" onclick = window.open("http://localhost:8080/LastProject_war/login_succes.jsp")>

</body>
</html>
