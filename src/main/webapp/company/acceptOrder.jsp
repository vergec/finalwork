<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/showInfo.css" type="text/css">
</head>
<body>

<form id="form" method="post" action="acceptOrder">
    <h2>请选择运输车辆</h2>
    <s:select list="#request.carEntityList" name="acceptOrderParam.carid" listKey="carid" listValue="carid" headerValue="请选择"/>
    <h2>请选择运输人员</h2>
    <s:select list="#request.employeeEntityList" name="acceptOrderParam.employeeid" listKey="employeeid" listValue="name" headerValue="请选择"/>
    <h2>请输入价格</h2>
    <input name="acceptOrderParam.price" type="text" title="">
    <input type="submit" value="提交" class="btn btn-primary">
</form>
</body>
</html>
