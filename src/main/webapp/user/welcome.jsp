<%--
  Created by IntelliJ IDEA.
  User: Verge_C
  Date: 2018/12/16
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding-right: 1000px">
	<div class="container">
		<div class="row" style="margin-bottom: 50px">
			<div class="col-xs-2 "><img src="/uploads/${sessionScope.user.img}" alt="用户头像" width="100px"/></div>
			<div class="col-xs-10 "><h2>${sessionScope.user.username},欢迎你</h2></div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-xs-8 ">点击左侧菜单选择功能</div>
			<div class="col-xs-6 "></div>
		</div>
	</div>
</div>

</body>
</html>
