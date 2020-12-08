<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/20
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除项目</title>
    <style>
        body{
            background-size: 1540px 720px;
        }
        #text{
            font-size: 20px;
            color: lightseagreen;
            margin-left: 600px;
        }
        #header{
            margin-top: 50px;
            background-color: lightseagreen;
            border: none;
            color: #fff;
            width: 300px;
            height: 30px;
            margin-left: 600px;
        }
        #id{
            border-color: goldenrod;
        }
        #reset{
            margin-top: 50px;
            background-color: lightseagreen;
            border: none;
            color: #fff;
            width: 300px;
            height: 30px;
            margin-left: 600px;
        }
        #x4{
            font-size: 25px;
            color: white;
            margin-left: 700px;
        }
        #x1{
            margin-top: 50px;
        }
    </style>
</head>
<body background="static/img/x7.jpg">

     <span id="x4">
         ${empty sessionScope.message10 ? "请输入" : sessionScope.message10}
     </span>

  <form id="x1" action="http://localhost:8080/LastProject_war/deleteproject" method="post">
      <label id="text">请输入项目ID：</label><input type="text" style= "background-color:transparent" id="id" name="ID">
      <br>
      <input type="submit" id="header" value="提交">
  </form>
  <form>
      <input id="reset" type="submit" value="返回主界面" onclick = window.open("http://localhost:8080/LastProject_war/login_succes.jsp")>
  </form>
</body>
</html>
