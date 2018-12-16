<!DOCTYPE html>
<html>
<head>
    <title>About Us</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //for-mobile-apps -->
    <link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- js -->
    <script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
    <!-- Stats-Number-Scroller-Animation-JavaScript -->
    <script src="/js/waypoints.min.js"></script>
    <script src="/js/counterup.min.js"></script>
    <script>
        jQuery(document).ready(function ($) {
            $('.counter').counterUp({
                delay: 10,
                time: 1000
            });
        });
    </script>
    <!-- //Stats-Number-Scroller-Animation-JavaScript -->
    <!-- //js -->
    <link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>
</head>
<%@ include file="common_header.jsp" %>
<body>
<!-- banner1 -->
<div class="banner1">
    <div class="container">
    </div>
</div>

<div class="services-breadcrumb">
    <div class="container">
        <ul>
            <li><a href="index.jsp">Home</a><i>|</i></li>
            <li>最新运输公司信息</li>
        </ul>
    </div>
</div>
<!-- //banner1 -->
<table id="table" class="table table-hover table-striped">
    <thead>
    <th style="text-align:center;">公司编号</th>
    <th style="text-align:center;">公司名称</th>
    <th style="text-align:center;">地址</th>
    <th style="text-align:center;">电话</th>
    <th style="text-align:center;">邮箱</th>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.get('companyList')}" var="ly">
        <tr>
            <td style="text-align:center;">${ly.companyid}</td>
            <td style="text-align:center;">${ly.companyname}</td>
            <td style="text-align:center;">${ly.address}</td>
            <td style="text-align:center;">${ly.phone}</td>
            <td style="text-align:center;">${ly.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- //about-bottom -->
<%@ include file="common_footer.jsp" %>
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
</body>
</html>