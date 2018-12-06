<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<table id="table" class="hoverTable">
    <tr>
        <th>公司编号</th>
        <th>登录名</th>
        <th>密码</th>
        <th>公司名称</th>
        <th>地址</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>操作</th>
        <th>重置</th>
    </tr>
        <s:iterator value="companyEntity" var="ly">
        <form method="post" action="updateCompanyAction">
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                <td><input type="text" name="companyEntity.companyid" value="${ly.companyid}" size="10" readOnly="true"></td>
                <td><input type="text" name="companyEntity.loginname" value="${ly.loginname}" size="10"></td>
                <td><input type="text" name="companyEntity.secret" value="${ly.secret}" size="10"></td>
                <td><input type="text" name="companyEntity.companyname" value="${ly.companyname}" size="10" readOnly="true"></td>
                <td><input type="text" name="companyEntity.address" value="${ly.address}" size="10"></td>
                <td><input type="text" name="companyEntity.phone" value="${ly.phone}" size="10"></td>
                <td><input type="text" name="companyEntity.email" value="${ly.email}" size="10"></td>
                <td><input type="submit" value="修改"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </form>
        </s:iterator>
</table>
</body>
</html>
