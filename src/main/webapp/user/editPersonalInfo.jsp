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
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div id="show">
    <div id="info">
        <form action="editInfo" method="post" id="form" enctype="multipart/form-data">
            <table id="table" class="table table-hover table-striped">
                <tr>
                    <td>用户名</td>
                    <td><input type="text" class="form-control" id="id" name="userEntity.username" title="" value="${sessionScope.user.loginname}" /></td>
                </tr>
                <tr>
                    <td>新密码</td>
                    <td><input type="text" class="form-control" id="companyname" name="userEntity.secret" title="" /></td>
                </tr>
                <tr>
                    <td>电话号码</td>
                    <td><input type="text" class="form-control" id="destination" name="userEntity.phone" title="" value="${sessionScope.user.phone}"/></td>
                </tr>
                <tr>
                    <td>电子邮件</td>
                    <td><input type="text" class="form-control" id="time" name="userEntity.email" title="" value="${sessionScope.user.email}"/></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="radio" id="male" name="userEntity.sex" title="" value="男"/>男<input type="radio" id="female" name="userEntity.sex" value="女" title=""/>女</td>
                </tr>
				<tr>
					<td>头像</td>
					<td><input type="file" name="file"/></td>
				</tr>
            </table>
            <input type="submit" value="确认更改" id="submit"  class="btn btn-primary">
        </form>
    </div>
</div>
<script>
    if('${sessionScope.user.sex}'==='男'){
        document.getElementById('male').checked="checked";
    } else {
        document.getElementById('female').checked="checked";
    }
</script>
</body>
</html>
