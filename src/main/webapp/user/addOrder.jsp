<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Verge_C
  Date: 2018/6/2
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>新建订单页面</title>
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div id="show">
	<div id="info">
		<form action="addOrder" method="post" id="form">
			<table id="table" class="table table-hover table-striped">
				<tr>
					<td>订单标题</td>
					<td><input type="text" id="title" name="orderEntity.title" title="" size="35"></td>
				</tr>
				<tr>
					<td>出发地</td>
					<td><input type="text" id="departure" name="orderEntity.departure" title="" size="35"></td>
				</tr>
				<tr>
					<td>目的地</td>
					<td><input type="text" id="destination" name="orderEntity.destination" title="" size="35"></td>
				</tr>
				<tr>
					<td>货物数量(件)</td>
					<td><input type="text" name="orderEntity.itemamount" title=""></td>
				</tr>
				<tr>
					<td>货物重量(kg)</td>
					<td><input type="text" name="orderEntity.itemsize" title=""></td>
				</tr>
				<tr>
					<td>期望取件时间</td>
					<td>
						<input type="datetime-local" name="time"/>~
						<input type="datetime-local" name="time" />
					</td>
				</tr>
			</table>
			<input type="submit" value="提交" id="submit" style="align-content: center;" class="btn btn-primary">
		</form>
	</div>
</div>
</body>
</html>
