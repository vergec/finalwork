<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.EvaluationBean" %>
<%@ page import="DAO.CompanyDAO" %>
<%@ page import="JavaBean.CompanyBean" %><%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/2
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<%
    CompanyBean arrayList = new CompanyDAO().getCompany((Integer) session.getAttribute("companyid"));
    request.setAttribute("arrayList", arrayList);
%>
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
        <form method="post" action="UpdateCompany">
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                <td><input type="text" name="companyid" value="${arrayList.companyid}" size="10" readOnly="true"></td>
                <td><input type="text" name="loginname" value="${arrayList.loginname}" size="10"></td>
                <td><input type="text" name="secret" value="${arrayList.secret}" size="10"></td>
                <td><input type="text" name="companyname" value="${arrayList.companyname}" size="10" readOnly="true"></td>
                <td><input type="text" name="address" value="${arrayList.address}" size="10"></td>
                <td><input type="text" name="phone" value="${arrayList.phone}" size="10"></td>
                <td><input type="text" name="email" value="${arrayList.email}" size="10"></td>
                <td><input type="submit" value="修改"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </form>
</table>
</body>
</html>
