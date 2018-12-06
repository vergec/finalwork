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
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <title>Title</title>
</head>
<body>
<form method="post" action="addEmployeeAction" id="form">
    <table id="table" class="hoverTable">
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="employeeEntity.name"></td>
        </tr>
        <tr>
            <td>员工职位</td>
            <td><input type="text" name="employeeEntity.position"></td>
        </tr>
        <tr>
            <td>员工电话</td>
            <td><input type="text" name="employeeEntity.phone"></td>
        </tr>
    </table>
    <input type="submit" value="增加">
    <input type="reset" value="重置">
</form>
</body>
</html>
