<%@ page import="java.util.List" %>
<%@ page import="com.gl.dao.impl.RespondentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/25
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%--    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
    <title>被投票目标票数</title>
    <script type="text/javascript">
        <%
    List Respondentlist = new RespondentDaoImpl().GetRespondent((String)request.getSession().getAttribute("projectID"));
    request.getSession().setAttribute("list",Respondentlist);
%>
    </script>
    <style>
        body{
            background-size: 1540px 720px;
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
        #x1{
            font-size: 25px;
            color: white;
            text-align: center;
            margin-left: 700px;
        }
        #x2{
            font-size: 25px;
            color: white;
            text-align: center;
        }
    </style>
</head>
<body background="static/img/x22.jpg">

  <form>
<c:forEach items="${sessionScope.list}" var="list" varStatus="vs">
    <span id="x1">${list.name}:</span>
       <span id="x2">票数为：${list.score}</span>
      <br>
</c:forEach>
      <input type="submit" id="reset" value="返回主界面" onclick = window.open("http://localhost:8080/LastProject_war/login_succes.jsp")>
  </form>

</body>
</html>
