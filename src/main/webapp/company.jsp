<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/backstage_common.css"/>
    <script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <title>主页面</title>
</head>
<body>
<div id="big">
    <img src="img/index/background.jpg" width="1402px"/>
    <div id="container">
        <div id="nav">
            <ul class="nav nav-pills nav-stacked" role="tablist" style="width: 180px">
                <li class="active"><a href="#">运输公司信息管理</a></li>
                <li><a href="listOrderAction" target="in">查看和操作订单</a></li>
                <li><a href="listCarAction" target="in">查看修改和删除车辆</a></li>
                <li><a href="company/addCar.jsp" target="in">增加车辆</a></li>
                <li><a href="listEmployeeAction" target="in">查看修改和删除员工</a></li>
                <li><a href="company/addEmployee.jsp" target="in">增加员工</a></li>
                <li><a href="listCompanyAction" target="in">查看和修改公司信息</a></li>
                <li><a href="listCompanyEvaluationAction" target="in">查看公司订单评价</a></li>
            </ul>
        </div>
        <div id="frame">
            <iframe class="s" name="in" width="1200px" height="1000px" frameborder="no" border="0"></iframe>
        </div>
    </div>
</div>
</body>
</html>