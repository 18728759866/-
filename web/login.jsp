<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2020/7/16
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>川农投票登录页面</title>

  <link type="text/css" rel="stylesheet" href="http://localhost:8080/LastProject_war/static/css/style.css">

  <style>
    body {
      overflow: hidden;
    }

    * {
      margin: 0;
      font-family:"Microsoft Yahei";
      color: #666;
    }

    div{
      margin: auto;
      margin-bottom: 10px;
      margin-top: 10px;

    }
    
    .book_info div{
      height: 10px;
      width: 300px;
      text-align: left;
    }

    .logo_img{
      float: left;
      height: 100px;
      width: 150px;
    }

    #header div a {
      text-decoration: none;
      font-size: 20px;
    }

    #header div{
      float: right;
      margin-top: 55px;
    }


    .book_cond input{
      width: 50px;
      text-align: center;
    }


    /*登录页面CSS样式  */

    #login_header{
      height: 100px;
      width: 1200px;
    }

    .login_banner{
      height:475px;
      background-color: #39987c;
    }

    .login_form{
      height:310px;
      width:406px;
      float: right;
      margin-right:50px;
      margin-top: 50px;
      background-color: #fff;
    }

    #content {
      height: 475px;
      width: 1200px;
    }

    .login_box{
      margin: 20px;
      height: 260px;
      width: 366px;
    }

    h1 {
      font-size: 20px;
    }
    .msg_cont{
      background: none repeat scroll 0 0 #fff6d2;
      border: 1px solid #ffe57d;
      color: #666;
      height: 18px;
      line-height: 18px;
      padding: 3px 10px 3px 40px;
      position: relative;
      border: none;
    }

    .msg_cont b {
      background: url("http://localhost:8080/LastProject_war/static/img/pwd-icons-new.png") no-repeat scroll -104px -22px rgba(0, 0, 0, 0);
      display: block;
      height: 17px;
      left: 10px;
      margin-top: -8px;
      overflow: hidden;
      position: absolute;
      top: 50%;
      width: 16px;
    }

    .form .itxt {
      border: 0 none;
      float: none;
      font-family: "宋体";
      font-size: 14px;
      height: 18px;
      line-height: 18px;
      overflow: hidden;
      padding: 10px 0 10px 10px;
      width: 220px;
      border: 1px #e3e3e3 solid;
    }

    #sub_btn{
      background-color: #39987c;
      border: none;
      color: #fff;
      width: 180px;
      height: 40px;
    }

    #l_content {
      float: left;
      margin-top: 150px;
      margin-left: 300px;
    }

    #l_content span {
      font-size: 60px;
      color: white;
    }

    .tit h1 {
      float: left;
      margin-top: 5px;
    }

    .tit a {
      float: right;
      margin-left: 10px;
      margin-top: 10px;
      color: red;
      text-decoration: none;
    }


    .tit {
      height: 30px;
    }
    /*购物车*/
    #main table{
      margin: auto;
      margin-top: 80px;
      border-collapse: collapse;
    }

    #main table td{
      width: 120px;
      text-align:center;
      border-bottom: 1px #e3e3e3 solid;
      padding: 10px;
    }

    .cart_span span{
      color: red;
      font-size: 20px;
      margin: 10px;
    }

    .cart_span a , td a{
      font-size: 20px;
      color: blue;
    }

    #header div span {
      margin: 10px;
    }
    #header div a {
      color: blue;
    }
    .text{
      font-size: 40px;
      align-content: center;
      color: green;
      margin-left: 400px;
      padding-top: 10px;
    }
    #pass1{
      background-color: #39987c;
      border: none;
      color: #fff;
      width: 180px;
      height: 40px;
    }

  </style>
</head>
<body>

<div id="login_header">
  <img class="logo_img" alt="" src="http://localhost:8080/LastProject_war/static/img/川农.png" >
  <h1 class="text">四川农业大学投票系统</h1>
</div>

<div class="login_banner">

  <div id="l_content">
    <span class="login_word">欢迎登录</span>
  </div>

  <div id="content">
    <div class="login_form">
      <div class="login_box">
        <div class="tit">
          <h1>四川农业大学</h1>
          <a  id ="x1" href="http://localhost:8080/LastProject_war/register.jsp">立即注册</a>
        </div>
        <div class="msg_cont">
          <b></b>
          <span id="errorMsg">
            ${ empty sessionScope.msg ? "请输入用户名和密码":sessionScope.msg }
          </span>
        </div>
        <div class="form">
          <form action="http://localhost:8080/LastProject_war/login" method="post">
            <input type="hidden" name="action" value="login" />
            <label>用户名称：</label>
            <input class="itxt" type="text" placeholder="请输入用户名"
                   autocomplete="off" tabindex="1" name="username"
                   value="${sessionScope.username}" />
            <br/>
            <br/>
            <label>用户密码：</label>
            <input class="itxt" type="password" placeholder="请输入密码"
                   autocomplete="off" tabindex="1" name="password" />
            <br />
            <br />
            <input type="submit" value="登录" id="sub_btn" />
            <input  type="submit" value="重置密码" id="pass1" onclick=window.open("http://localhost:8080/LastProject_war/ResettingPassword.jsp")>
          </form>
        </div>

      </div>
    </div>
  </div>
</div>

<%--静态包含页脚内容--%>
</body>
</html>