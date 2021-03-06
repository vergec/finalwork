<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/Logout animation concept</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
    <link rel="stylesheet" href="../css/login_register.css">
    <link rel="stylesheet" href="../css/register.css" type="text/css">
</head>
<body>
<div class="cont">
    <div class="demo">
        <div class="login">
            <div class="login__check"></div>
            <div class="login__form">
                <form action="registerAction" method="post">
                    <div class="login__row">
                        <input type="text" class="login__input" placeholder="loginname" name="loginname"/>
                    </div>
                    <div class="login__row">
                        <input type="password" class="login__input" placeholder="Password" name="password"/>
                    </div>
                    <div class="login__row">
                        <input type="text" class="login__input" placeholder="name" name="name"/>
                    </div>
                    <div class="login__row">
                        <input type="text" class="login__input" placeholder="phone" name="phone"/>
                    </div>
                    <div class="login__row">
                        <input type="text" class="login__input" placeholder="Email" name="email"/>
                    </div>
                    <br>
                    <%--<input name="kind" type="radio" value="user"/>用户&nbsp;--%>
                    <%--<input name="kind" type="radio" value="company"/>运输公司--%>
                    <input type="submit" class="login__submit" value="注册">
                </form>
                <p class="login__signup">Alreadly have an account &nbsp;<a href="login.jsp">Sign in</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
