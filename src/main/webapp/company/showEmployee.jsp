  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/2
  Time: 13:19
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
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>员工职位</th>
        <th>员工电话</th>
        <th>操作</th>
        <th>重置</th>
    </tr>
    <s:iterator value="employee" var="ly">
        <form method="post" action="UpdateEmployee">
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                <td><input type="text" name="employeeid" value="${ly.employeeid}" size="10"></td>
                <td><input type="text" name="name" value="${ly.name}" size="10"></td>
                <td><input type="text" name="position" value="${ly.position}" size="10"></td>
                <td><input type="text" name="phone" value="${ly.phone}" size="10"></td>
                <td><input type="submit" value="修改">
                    <input type="button"
                           onclick="window.location.href='DeleteEmployee?id=${ly.employeeid}'"
                           value="删除">
                </td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </form>
    </s:iterator>
</table>
</body>
</html>
