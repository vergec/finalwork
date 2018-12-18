<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/backstage_common.css"/>
    <script src="../js/jquery.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <title>主页面</title>
</head>
<body>
<div id="big">
    <img src="../img/index/background.jpg" width="1402px"/>
    <div id="container">
        <div id="nav">
            <ul class="nav nav-pills nav-stacked" role="tablist" style="width: 180px">
                <li class="active"><a href="#">欢迎你,管理员</a></li>
                <li><a href="adminGetAllCompanyAction" target="in">管理运输公司</a></li>
                <li><a href="getAllUserAction" target="in">管理用户</a></li>
                <li><a href="getAllEvaluationAction" target="in">管理评价</a></li>
                <li><a href="../index.jsp">退出系统</a></li>
            </ul>
        </div>
        <div id="frame">
            <iframe class="s" name="in" width="1200px" height="1000px" frameborder="no" border="0"></iframe>
        </div>
    </div>
</div>
</body>
</html>