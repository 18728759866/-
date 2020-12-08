<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <script type="text/javascript" src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>

    <meta charset="UTF-8">
    <title>川农投票注册页面</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
<%--    <%@ include file="/pages/common/head.jsp"%>--%>


    <script type="text/javascript" >
        // 页面加载完成之后
        $(function () {
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱里的内容
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3 使用test方法验证是否合法
                if (!emailPatt.test(emailText)) {
                    //4 提示用户
                    $("span.errorMsg").text("邮箱格式为xxxxx@xxx.com");

                    return false;
                }

                var codeText = $("#code").val();

                codeText = $.trim(codeText);

                if (codeText == null || codeText == "") {
                    //4 提示用户
                    $("span.errorMsg").text("验证码不能为空！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });
            $("#code_img").click(function () {
                  this.src ="http://localhost:8080/LastProject_war/kaptcha.jpg";
            })

        });

    </script>
    <style type="text/css">
        .login_form{
            height:520px;
            margin-top: 25px;
        }


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
            height:380px;
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
            height: 10px;
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

        .tit .errorMsg {
            float: right;
            margin-left: 10px;
            margin-top: 10px;
            color: red;
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

        #header div .um_span{
            color: red;
            font-size: 25px;
            margin: 10px;
        }

        #header div a {
            color: blue;
        }
        #test{
            background-color: #39987c;
            border: none;
            color: #fff;
            width: 180px;
            height: 40px;
        }
        #test1{
            margin-left: 12px;
        }
        .text{
            font-size: 40px;
            align-content: center;
            color: green;
            margin-left: 400px;
            padding-top: 10px;
        }
    </style>
</head>
<body>

<div id="login_header">
    <img class="logo_img" alt="" src="static/img/川农.png" >
    <h1 class="text">四川农业大学投票系统</h1>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>四川农业大学</h1>
                    <span class="errorMsg">
                        ${ empty sessionScope.message ? "请注册":sessionScope.message }
                    </span>
                </div>
                <div class="form">
                    <form action="http://localhost:8080/LastProject_war/register" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               value=""
                               autocomplete="off" tabindex="1" name="username" id="username" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password" />
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd" />
                        <br />
                        <br />
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               value=""
                               autocomplete="off" tabindex="1" name="email" id="email" />
                        <br />
                        <br />
                        <label id="test1">验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;" id="code" />
                        <img  id="code_img" alt="" src="http://localhost:8080/LastProject_war/kaptcha.jpg" style="float: right;width: 100px; height: 40px; margin-right: 10px">
                        <br />
                        <br />
                        <input type="submit" value="注册" id="sub_btn" />
                        <input type="submit" value="返回登录" id="test" onclick=window.open("http://localhost:8080/LastProject_war/login.jsp")>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--静态包含页脚内容--%>
<%--<%@include file="/pages/common/footer.jsp"%>--%>


</body>
</html>