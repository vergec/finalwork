<%--
  Created by IntelliJ IDEA.
  User: machenike
  Date: 2018/6/6 0006
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<%-- 提交评价表单，id信息隐藏不会显示 --%>
<form method="post" action="../addEvaluation?orderid=${b.orderid}" enctype="multipart/form-data" id="form">
    <table class="table table-hover table-striped" id="table">
        <tr><td>评论标题</td><td><input type="text" name="evaluationEntity.title"/></td></tr>
		<tr><td>评论内容</td><td><textarea name="evaluationEntity.content" cols="30" rows="4"></textarea></td></tr>
        <tr><td>上传照片</td><td><input type="file" name="file" size="23"/></td></tr>
		<tr>
			<td style="text-align:center;" colspan="2">
				<input type="submit" value="增加" class="btn btn-primary"/>
				<input type="reset" value="重置" class="btn btn-primary"/>
			</td>
		</tr>
    </table>

</form>
</body>
</html>
