<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<table id="table" class="table table-hover table-striped">
	<thead>
        <th style="text-align:center;">公司编号</th>
        <th style="text-align:center;">公司名称</th>
        <th style="text-align:center;">地址</th>
        <th style="text-align:center;">电话</th>
        <th style="text-align:center;">邮箱</th>
		<th style="text-align:center;">操作</th>
	</thead>
	<tbody>
	<c:forEach items="${sessionScope.get('companyList')}" var="ly">
		<tr>
			<form action="setCompanyIdToSession?companyId=${ly.companyid}" method="post">
				<td style="text-align:center;">${ly.companyid}</td>
				<td style="text-align:center;">${ly.companyname}</td>
				<td style="text-align:center;">${ly.address}</td>
				<td style="text-align:center;">${ly.phone}</td>
				<td style="text-align:center;">${ly.email}</td>
				<td style="text-align:center;"><input type="submit" value="选择" class="btn btn-info"  style="text-align:center;"/></td>
			</form>

		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
