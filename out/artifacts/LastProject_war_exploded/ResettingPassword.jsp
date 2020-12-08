<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/19
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <script type="text/javascript">
       ${sessionScope.notExist}
    </script>
    <style>
        body{
            background-size: 1540px 720px;
        }
        .x2{
            margin-left: 30px;
            width: 150px;
            height: 30px;
            background-color: bisque;
            border-radius: 20%;
            font-size: 18px;
        }
        .text_field{
            border-color: lightpink;
            border-radius: 10%;
        }
        .text{
            font-size: 18px;
            color: bisque;
        }
        .x1{
            margin-top: 100px;
            margin-left: 550px;
            border: solid 2px whitesmoke;
            width: 400px;
            height: 200px;
        }
        .text1{
            font-size: 18px;
            color: bisque;
        }
        .x3{
            width: 400px;
            height: 30px;

        }
        .x4{
            width: 400px;
            height: 50px;

            margin-left: 16px;
        }
        .x5{
            width: 400px;
            height: 50px;

        }
        .x6{
            width: 400px;
            height: 50px;

        }
        .s1{
            margin-left: 20px;
            width: 150px;
            height: 30px;
            background-color: bisque;
            border-radius: 20%;
            font-size: 18px;
        }
        .errorMsg{
            font-size: 18px;
            margin-left: 150px;
            color: bisque;
        }
    </style>
</head>

<body background="static/img/x6.jpg">
<div class="x1">
<form action="http://localhost:8080/LastProject_war/resetpsd" method="post">
    <div class="x3">
        <span class="errorMsg">
            ${ empty sessionScope.notExist ? "请输入":sessionScope.notExist }
        </span>
    </div>


    <div class="x4">
        <label class="text">请输入您的邮箱：</label><input style= "background-color:transparent" type="text" class="text_field" name="email">

    </div>


    <div class="x5">
        <label class="text1">请输入修改的密码：</label><input type="text" name="password" class="text_field" style= "background-color:transparent">

    </div>

    <div class="x6">
        <form>
            <input class="x2" type="submit" value="提交" >
            <input class="s1" type="submit" value="返回登录界面" onclick=window.open("http://localhost:8080/LastProject_war/login.jsp")>
        </form>
    </div>

</form>
</div>
</body>
</html>
