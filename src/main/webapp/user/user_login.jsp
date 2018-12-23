<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login/Logout animation concept</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
    <link rel="stylesheet" href="../css/login_register.css" type="text/css">
    <link rel="stylesheet" href="../css/login.css" type="text/css">
</head>
<body>
<div class="cont">
    <div class="demo">
        <div class="login">
            <div class="login__check"></div>
            <div class="login__form">
                <form action="userLoginAction" method="post">
                    <div class="login__row">
                        <input type="text" class="login__input" placeholder="Username" name="userEntity.loginname"/>
                    </div>
                    <div class="login__row">
                        <input type="password" class="login__input" placeholder="Password" name="userEntity.secret"/>
                    </div>
                    <br>
                    <input type="submit" class="login__submit" value="登陆">
                </form>
                <p class="login__signup">Don't have an account? &nbsp;<a href="user_register.jsp">Sign up</a></p>
                <p class="login__signup">公司用户登录入口 &nbsp;<a href="../company/login.jsp">Sign in</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
