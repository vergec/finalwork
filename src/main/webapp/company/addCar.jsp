<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/5
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <title>Title</title>
</head>
<body>

<form method="post" action="AddCar" id="form">
    <table id="table" class="hoverTable">
        <tr>
            <td>司机编号</td>
            <td><input type="text" name="driverid"></td>
        </tr>
        <tr>
            <td>车辆类型</td>
            <td><input type="text" name="kind"></td>
        </tr>
        <tr>
            <td>车牌号码</td>
            <td><input type="text" name="number"></td>
        </tr>
    </table>
    <input type="submit" value="增加">
    <input type="reset" value="重置">
</form>
</body>
</html>
