<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form action="adminLogin" method="post">
                    <div class="login__row">
                        <input type="text" class="login__input" placeholder="adminName" name="administratorEntity.loginname"/>
                    </div>
                    <div class="login__row">
                        <input type="password" class="login__input" placeholder="Password" name="administratorEntity.secret"/>
                    </div>
                    <br>
                    <input type="submit" class="login__submit" value="登录">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
