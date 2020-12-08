<%@ page import="com.gl.dao.impl.ProjectDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/20
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户创建投票页</title>
    <script type="text/javascript">
        <%
        Integer votecount =new ProjectDaoImpl().GetVoteCount((String)request.getSession().getAttribute("username"),(String)request.getSession().getAttribute("projectID"));
        request.getSession().setAttribute("votecount",votecount);
        %>

    </script>
    <style>
        #head{
            color: #39987c;
            font-size: 40px;
            margin-left: 550px;
        }
        #body{
            border: solid 2px silver;
            height: 350px;
        }
        .x1{
            padding-left: 1300px;
            font-size: 18px;
            font-weight: bold;
            display: flex;
            color: lightseagreen;
            font-weight: bold;
        }
        .x2{
            display: flex;
            margin-top: 18px;
            margin-left: 10px;
            font-size: 20px;
            color: green;
        }
        #head_x1{
            display: flex;
            width: 100%;
        }
        .x3{
            font-size: 30px;
            padding-left: 550px;
            color: lightseagreen;
            margin-top: 10px;
            height: 30px;
        }
        .body_x1{
            background-color: lightseagreen;
            border: none;
            color: #fff;
            width: 140px;
            height: 40px;
        }
        #body_s1{
            margin-left: 650px;
        }
        #body_s2{
            margin-left: 10px;
        }
        #body_s3{
            margin-left: 495px;
        }
        #body_s4{
            margin-left: 500px;
        }
        #body_s5{
            margin-left: 10px;
        }
        #body_s6{
            margin-left: 495px;
        }
        #body_s7{
            margin-left: 500px;
        }
        #body_s8{
            margin-left: 300px;
        }
        #s1{
            display: flex;
        }
        #body_s9{
            margin-left: 550px;
        }
        #body_s10{
            margin-left: 650px;
        }
        #footer{
            margin-top: 5px;
            width: 1505px;
            height: 215px;
        }
    </style>
</head>
<body>
<h1 id="head">四川农业大学投票系统</h1>
<div id="head_x1">
<p class="x1">欢迎</p>
<span class="x2">
    ${sessionScope.username}
</span>
</div>
<div id="body">
    <p class="x3">请点击按钮来执行相应的功能</p>
<form action="http://localhost:8080/LastProject_war/cancreatproject" method="post">
    <input class="body_x1"  id="body_s1" type="submit" value="创建项目">
</form>
   <form>
       <input class="body_x1" id="body_s2" type="submit" value="创建评委" onclick = window.open("http://localhost:8080/LastProject_war/creatjudge.jsp")>
       <input  class="body_x1" id="body_s3" type="submit" value="创建被投票的目标" onclick = window.open("http://localhost:8080/LastProject_war/creatrespondent.jsp")>
       <input  class="body_x1" id="body_s4" type="submit" value="删除项目" onclick = window.open("http://localhost:8080/LastProject_war/deleteproject.jsp")>
       <br>
       <br>
       <input  class="body_x1" id="body_s5" type="submit" value="展示被投票目标的票数" onclick = window.open("http://localhost:8080/LastProject_war/datashow.jsp")>
       <input  class="body_x1" id="body_s6" type="submit" value="评委登录" onclick = window.open("http://localhost:8080/LastProject_war/judgelogin.jsp")>
       <input  class="body_x1" id="body_s7" type="submit" value="评委投票" onclick = window.open("http://localhost:8080/LastProject_war/judgevoteandlogin.jsp")>
   </form>
    <div id="s1">
<form action="http://localhost:8080/LastProject_war/overvote" method="post">
<input  class="body_x1" id="body_s8" type="submit" value="结束投票">
<c:if test="${sessionScope.votecount != 0}">
    </form>
    <form action="http://localhost:8080/LastProject_war/nextvote" method="post">
    <input  id="body_s9" class="body_x1" type="submit" value="下一轮投票">
    </form>
    </div>

   </c:if>

       <input  id="body_s10" class="body_x1" type="submit" value="退出当前用户登录" onclick = window.open("http://localhost:8080/LastProject_war/login.jsp")>
</div>
<c:if test="${sessionScope.username == null}">
    <%
        request.getSession().setAttribute("msg","没有权限,请先登录");
        response.sendRedirect("http://localhost:8080/LastProject_war/login.jsp");
    %>
</c:if>
  <img id="footer" src="static/img/x11.jpg">
</body>
</html>
