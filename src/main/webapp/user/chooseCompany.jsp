<%@ page import="DAO.CompanyDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.CompanyBean" %><%--
  Created by IntelliJ IDEA.
  User: Verge_C
  Date: 2018/6/6
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择运输公司</title>
    <link rel="stylesheet" type="text/css" href="../css/showInfo.css">
    <%
        CompanyDAO companyDAO = new CompanyDAO();
        ArrayList<CompanyBean> res = companyDAO.getAllCompany();
    %>
</head>
<body>
<div id="show">
    <div id="info">
        <form action="addOrder.jsp" method="get">
            <h2>请选择运输公司</h2>
            <select name="company" title="">
                <% for(CompanyBean bean:res){%>
                <option  value="<%= bean.getCompanyid()%>" style="width: 100px"><%= bean.getCompanyname()%></option>
                <%}%>
            </select>
            <input type="submit" value="下一步">
        </form>
    </div>
</div>
</div>
</body>
</html>
