<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
	<script>
        function goTo() {
            var p = document.getElementById("goto");
            var txt = p.value;
            window.location = "showOrder?page=" + txt + "";
        }
	</script>
</head>
<body>
<table id="table" class="table table-hover table-striped">
	<thead>
		<th>订单标题</th>
		<th>始发地</th>
		<th>目的地</th>
		<th>状态</th>
		<th>操作</th>
	</thead>
	<tbody>
	<s:iterator value="#request.res.data" var="order" status="i">
		<tr>
			<form action="detailedOrderCreator?orderid=${order.orderid}" method="post">
				<td>${order.title}</td>
				<td>${order.departure}</td>
				<td>${order.destination}</td>
				<td>${order.status}</td>
				<td><input type="submit" value="查看详情" class="btn btn-info"></td>
			</form>
		</tr>
	</s:iterator>
	</tbody>

</table>
<div style="align-content: center">
	<input type="button" onclick="window.location='showOrder?page=${page-1}'" value="上一单" id="left" class="btn btn-primary">
	<input type="button" onclick="window.location='showOrder?page=${page+1}'" value="下一单" id="right" class="btn btn-primary">
	当前第${page}页，总共${requestScope.res.totalPages}页<input type="text" id="goto" title=""
														style="width: 50px">&nbsp;&nbsp;<input type="button"
																							   onclick="goTo()" value="跳转" class="btn btn-success">
</div>
</body>
</html>
