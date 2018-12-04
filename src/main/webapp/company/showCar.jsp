<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/4
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DAO.CompanyDAO" %>
<%@ page import="JavaBean.CarBean" %>
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
    System.out.println(session.getAttribute("companyid"));
    ArrayList<CarBean> arrayList = new CompanyDAO().getCompanyCar((Integer) session.getAttribute("companyid"));
    request.setAttribute("arrayList", arrayList);
%>
<table class="hoverTable" id="table">
    <tr>
        <th>车辆编号</th>
        <th>司机编号</th>
        <th>车辆类型</th>
        <th>车牌号码</th>
        <th>操作</th>
        <th>重置</th>
    </tr>
    <c:forEach items="${arrayList}" var="ly">
        <form method="post" action="UpdateCar">
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                <td><input type="text" name="carid" value="${ly.carid}" size="10"></td>
                <td><input type="text" name="driverid" value="${ly.driverid}" size="10"></td>
                <td><input type="text" name="kind" value="${ly.kind}" size="10"></td>
                <td><input type="text" name="number" value="${ly.number}" size="10"></td>
                <td><input type="submit" value="修改">
                    <input type="button"
                           onclick="window.location.href='DeleteCar?id=${ly.carid}'"
                           value="删除">
                </td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>

