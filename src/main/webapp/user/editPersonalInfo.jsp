<%--
  Created by IntelliJ IDEA.
  User: Verge_C
  Date: 2018/6/2
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <link type="text/css" href="../css/showInfo.css" rel="stylesheet">
</head>
<body>
<div id="show">
    <div id="info">
        <form action="EditUser" method="post" id="form">
            <table id="table" class="hoverTable">
                <tr>
                    <td>用户名</td>
                    <td><input type="text" id="id" name="username" title="" value="${sessionScope.tempUserBean.loginName}" ></td>
                </tr>
                <tr>
                    <td>新密码</td>
                    <td><input type="text" id="companyname" name="password" title="" ></td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td><input type="text" id="departure" name="password1" title="" ></td>
                </tr>
                <tr>
                    <td>电话号码</td>
                    <td><input type="text" id="destination" name="phone" title="" value="${sessionScope.tempUserBean.phone}"></td>
                </tr>
                <tr>
                    <td>电子邮件</td>
                    <td><input type="text" id="time" name="email" title="" value="${sessionScope.tempUserBean.email}"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="radio" id="male" name="sex" title="" value="男">男<input type="radio" id="female" name="sex" value="女" title="">女</td>
                </tr>
            </table>
            <input type="submit" value="确认更改" id="submit">
        </form>
    </div>
</div>
<script>
    if('${sessionScope.tempUserBean.sex}'=='男'){
        document.getElementById('male').checked="checked";
    } else {
        document.getElementById('female').checked="checked";
    }
</script>
</body>
</html>
