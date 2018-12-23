<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
	<title>Title</title>
</head>
<body>
<table id="table" class="table table-hover table-striped">
	<tr>
		<th style="text-align:center;">用户编号</th>
		<th style="text-align:center;">订单编号</th>
		<th style="text-align:center;">时间</th>
		<th style="text-align:center;">标题</th>
		<th style="text-align:center;">评论内容</th>
		<th style="text-align:center;">评论图片</th>
	</tr>
	<s:iterator value="#session.evaluationEntityList" var="ly">
		<tr>
			<td style="text-align:center;">${ly.userid}</td>
			<td style="text-align:center;">${ly.orderid}</td>
			<td style="text-align:center;">${ly.time}</td>
			<td style="text-align:center;">${ly.title}</td>
			<td style="text-align:center;">${ly.content}</td>
			<td style="text-align:center;"><img src="/uploads/${ly.photo1}" width="100" alt=""></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>
