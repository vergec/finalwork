<%@ page import="JavaBean.CarBean" %>
<%@ page import="DAO.CompanyDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.EmployeeBean" %><%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/8
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/showInfo.css" type="text/css">
</head>
<body>
<%
    CompanyDAO companyDAO = new CompanyDAO();
    ArrayList<CarBean> res = companyDAO.getCompanyCar((Integer) session.getAttribute("companyid"));
    ArrayList<EmployeeBean> res1 = companyDAO.getCompanyEmployee((Integer) session.getAttribute("companyid"));
    int id=Integer.parseInt(request.getParameter("id"));
    int code=Integer.parseInt(request.getParameter("code"));
%>
<form id="form" method="post" action="EditOrder?code=1&id=<%=id%>">
    <h2>请选择运输车辆</h2>
    <select name="carid" title="">
        <% for (CarBean bean : res) {%>
        <option value="<%= bean.getCarid()%>" style="width: 100px"><%= bean.getCarid()%>
        </option>
        <%}%>
    </select>
    <h2>请选择运输人员</h2>
    <select name="employee" title="">
        <% for (EmployeeBean bean : res1) {%>
        <option value="<%= bean.getEmployeeid()%>" style="width: 100px"><%= bean.getName()%>
        </option>
        <%}%>
    </select>
    <h2>请输入价格</h2>
    <input name="price" type="text" title="">
    <input type="submit" value="修改">
</form>
</body>
</html>
