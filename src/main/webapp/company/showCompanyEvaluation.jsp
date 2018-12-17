<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.EvaluationBean" %>
<%@ page import="DAO.EvaluationDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: machenike
  Date: 2018/6/12 0012
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <title>Title</title>
</head>
<body>
<%
    ArrayList<EvaluationBean> arrayList = new EvaluationDAO().getCompanyEvaluation((Integer) session.getAttribute("companyid"));
    request.setAttribute("arrayList", arrayList);
%>
<table id="table" class="hoverTable">
    <tr>
        <th>评价编号</th>
        <th>用户编号</th>
        <th>物流公司编号</th>
        <th>订单编号</th>
        <th>时间</th>
        <th>标题</th>
        <th>评论内容</th>
        <th>评论图片</th>
    </tr>
    <c:forEach items="${arrayList}" var="ly">
        <form>
            <tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
                <td><input type="text" name="evaluationId" value="${ly.evaluationId}" size="10" readOnly="true"></td>
                <td><input type="text" name="userId" value="${ly.userId}" size="10" readOnly="true"></td>
                <td><input type="text" name="companyId" value="${ly.companyId}" size="10" readOnly="true"></td>
                <td><input type="text" name="orderId" value="${ly.orderId}" size="10" readOnly="true"></td>
                <td><input type="text" name="time" value="${ly.time}" size="10" readOnly="true"></td>
                <td style="size: 20px">${ly.title}</td>
                <td>${ly.content}</td>
                <td><img src="/uploads/${ly.photo1}" width="160" height="120"></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
