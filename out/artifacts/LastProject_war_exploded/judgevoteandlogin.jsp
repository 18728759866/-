<%@ page import="java.util.List" %>
<%@ page import="com.gl.dao.impl.RespondentDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/29
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评委投票或登录</title>
<%--    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
    <script>
        <%
    List list = new RespondentDaoImpl().GetRespondent((String)request.getSession().getAttribute("projectID"));
    request.getSession().setAttribute("list1",list);
%>
    </script>
</head>
<body>

     <c:if test="${sessionScope.judgeID == null}" >
         <%
             response.setHeader("refresh"," 0 ;url=http://localhost:8080/LastProject_war/judgelogin.jsp");

         %>

     </c:if>
<c:if test="${sessionScope.judgeID != null}">
    <%
        response.setHeader("refresh"," 0 ;url=http://localhost:8080/LastProject_war/judgevote.jsp");

    %>
    <%--    <c:forEach items="${sessionScope.list1}" var="list">--%>
<%--        <form action="http://localhost:8080/LastProject_war_exploded/judgevote" method="post">--%>
<%--        ${list.name}: ${list.introduce}<input type="radio" name="username" value="${list.name}">--%>
<%--        <br>--%>
<%--    </c:forEach>--%>
<%--    <input type="submit" value="投票">--%>
<%--    </form>--%>
<%--    <span>${empty sessionScope.message3 ? "请投票" : sessionScope.message3}</span>--%>
<%--    <input type="submit" value="返回主界面" onclick = window.open("http://localhost:8080/LastProject_war_exploded/login_succes.jsp")>--%>
</c:if>

</body>
</html>
