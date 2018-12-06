<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/4
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<table class="hoverTable" id="table">
    <tr>
        <th>车辆编号</th>
        <th>司机编号</th>
        <th>车辆类型</th>
        <th>车牌号码</th>
        <th>操作</th>
        <th>重置</th>
    </tr>
    <s:iterator value="carEntities" var="ly">
        <form method="post" action="updateCarAction">
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                <td><input type="text" name="carEntity.carid" value="${ly.carid}" size="10"></td>
                <td><input type="text" name="carEntity.driverid" value="${ly.driverid}" size="10"></td>
                <td><input type="text" name="carEntity.kind" value="${ly.kind}" size="10"></td>
                <td><input type="text" name="carEntity.number" value="${ly.number}" size="10"></td>
                <td>
                    <input type="submit" value="修改">
                    <input type="button"
                           onclick="window.location.href='deleteCarAction?carEntity.carid=${ly.carid}'"
                           value="删除">
                </td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </form>
    </s:iterator>
</table>
</body>
</html>

