<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/5
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../js/jquery.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <title>Title</title>
</head>
<body>
<form method="post" action="addEmployeeAction" id="form">
    <table class="table table-hover table table-striped">
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="employeeEntity.name" class="form-control"></td>
        </tr>
        <tr>
            <td>员工职位</td>
            <td><input type="text" name="employeeEntity.position" class="form-control"></td>
        </tr>
        <tr>
            <td>员工电话</td>
            <td><input type="text" name="employeeEntity.phone" class="form-control"></td>
        </tr>
    </table>
    <input type="submit" value="增加" class="btn btn-primary" >
    <input type="reset" value="重置" class="btn btn-info">
</form>
</body>
</html>
