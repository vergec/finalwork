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
        <th>评价编号</th>
        <th>用户编号</th>
        <th>物流公司编号</th>
        <th>订单编号</th>
        <th>时间</th>
        <th>标题</th>
        <th>评论内容</th>
        <th>评论图片</th>
    </tr>
    <s:iterator value="#evaluationEntityList" var="ly">
        <form>
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                <td><input type="text" name="evaluationId" value="${ly.evaluationId}" size="10" readOnly="true"></td>
                <td><input type="text" name="userId" value="${ly.userId}" size="10" readOnly="true"></td>
                <td><input type="text" name="companyId" value="${ly.companyId}" size="10" readOnly="true"></td>
                <td><input type="text" name="orderId" value="${ly.orderId}" size="10" readOnly="true"></td>
                <td><input type="text" name="time" value="${ly.time}" size="10" readOnly="true"></td>
                <td style="size: 20px">${ly.title}</td>
                <td>${ly.content}</td>
                <td><img src="/uploads/${ly.photo1}" width="160" height="120"></td>
            </tr>
        </form>
	</s:iterator>
</table>
</body>
</html>
