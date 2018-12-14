<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/backstage_common.css"/>
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
	<title>主页面</title>
</head>
<body>
<div id="big">
	<img src="../img/index/background.jpg" width="1402px"/>
	<div id="container">
		<div id="nav">
			<ul class="nav nav-pills nav-stacked" role="tablist" style="width: 180px">
				<li class="active"><a href="#">用户信息管理</a></li>
				<li><a href="getCompanyAction" target="in">发布订单</a></li>
				<li><a href="getCompanyAction" target="in">查看运输公司</a></li>
				<li><a href="showOrder" target="in">查看订单</a></li>
				<li><a href="showUser" target="in">修改个人信息</a></li>
			</ul>
		</div>
		<div id="frame">
			<iframe class="s" name="in" width="1200px" height="1000px" frameborder="no" border="0"></iframe>
		</div>
	</div>
</div>
</body>
</html>