<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //for-mobile-apps -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- load-more -->
    <script>
        $(document).ready(function () {
            size_li = $("#myList li").size();
            x = 1;
            $('#myList li:lt(' + x + ')').show();
            $('#loadMore').click(function () {
                x = (x + 1 <= size_li) ? x + 1 : size_li;
                $('#myList li:lt(' + x + ')').show();
            });
            $('#showLess').click(function () {
                x = (x - 1 < 0) ? 1 : x - 1;
                $('#myList li').not(':lt(' + x + ')').hide();
            });
        });
    </script>
    <!-- //load-more -->
    <link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>

</head>

<body>
<%@ include file="common_header.jsp" %>
<!-- banner -->
<div class="banner">
    <div class="container">
        <div class="w3ls_banner_info">
            <h2>transport</h2>
            <p>
                哪都通是国家“AAAAA”级物流企业，主营国运输业务。
                截止2014年2月末，公司已开设直营网点 4,300内公路多家，服务网络遍及全国，自有营运车辆8,700余台，
                全国转运中心总面积超过92万平方米公司始终以客户为中心随时候命、持续创新，
                始终坚持自建营业网点、自购进口车辆、搭建最优线路，优化运力成本，
                为客户提供快速高效、便捷及时、安全可靠的服务体验，助力客户创造最大的价值。
            </p>
            <div class="wthree_more">
                <a href="single.html" class="button--wayra button--border-thick button--text-upper button--size-s">Learn
                    More</a>
            </div>
        </div>
    </div>
</div>
<!-- //banner -->
<!-- banner-bottom1 -->
<div class="banner-bottom1">
    <div class="col-md-6 agile_banner_bottom1_left">
        <img src="images/5.jpg" alt=" " class="img-responsive"/>
    </div>
    <div class="col-md-6 agile_banner_bottom1_right">
        <h3>优质的车辆服务</h3>
        <p>哪都通公司拥有种类繁多的车辆类型，和优质的车辆服务，保障你的运输安全和提升你的服务体验。</p>
        <div class="details">
            <a href="">More Details</a>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<!-- banner-bottom1 -->
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/">网页模板</a></div>
<!-- news -->
<div class="news">
    <div class="container">
        <h3>news</h3>
        <p class="quia">from our blog</p>
        <div class="agileits_news_grids">
            <div class="tab-1 resp-tab-content">
                <div class="load_more">
                    <ul id="myList">
                        <li>
                            <div class="l_g">
                                <div class="col-md-6 agileits_news_grid_left">
                                    <div class="agileits_news_grid_left_gridl">
                                        <p class="para1">28 <span>June- 2016</span></p>
                                        <p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a
                                                href="#"><span>comments- 8</span></a></p>
                                        <p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a
                                                href="#"><span>view- 21</span></a></p>
                                    </div>
                                    <div class="agileits_news_grid_left_gridr">
                                        <img src="images/6.jpg" alt=" " class="img-responsive"/>
                                        <h4><a href="single.html">tempora incidunt sit</a></h4>
                                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse
                                            quam nihil molestiae consequatur, vel illum qui dolorem.</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="col-md-6 agileits_news_grid_left">
                                    <div class="agileits_news_grid_left_gridl">
                                        <p class="para1">30 <span>June- 2016</span></p>
                                        <p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a
                                                href="#"><span>comments- 5</span></a></p>
                                        <p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a
                                                href="#"><span>view- 34</span></a></p>
                                    </div>
                                    <div class="agileits_news_grid_left_gridr">
                                        <img src="images/7.jpg" alt=" " class="img-responsive"/>
                                        <h4><a href="single.html">illumqui dolorem eum</a></h4>
                                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse
                                            quam nihil molestiae consequatur, vel illum qui dolorem.</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </li>
                        <li>
                            <div class="l_g">
                                <div class="col-md-6 agileits_news_grid_left">
                                    <div class="agileits_news_grid_left_gridl">
                                        <p class="para1">28 <span>June- 2016</span></p>
                                        <p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a
                                                href="#"><span>comments- 8</span></a></p>
                                        <p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a
                                                href="#"><span>view- 21</span></a></p>
                                    </div>
                                    <div class="agileits_news_grid_left_gridr">
                                        <img src="images/8.jpg" alt=" " class="img-responsive"/>
                                        <h4><a href="single.html">tempora incidunt eius</a></h4>
                                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse
                                            quam nihil molestiae consequatur, vel illum qui dolorem.</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="col-md-6 agileits_news_grid_left">
                                    <div class="agileits_news_grid_left_gridl">
                                        <p class="para1">30 <span>June- 2016</span></p>
                                        <p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a
                                                href="#"><span>comments- 5</span></a></p>
                                        <p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a
                                                href="#"><span>view- 34</span></a></p>
                                    </div>
                                    <div class="agileits_news_grid_left_gridr">
                                        <img src="images/9.jpg" alt=" " class="img-responsive"/>
                                        <h4><a href="single.html">illumqui dolorem eum</a></h4>
                                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse
                                            quam nihil molestiae consequatur, vel illum qui dolorem.</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </li>
                        <li>
                            <div class="l_g">
                                <div class="col-md-6 agileits_news_grid_left">
                                    <div class="agileits_news_grid_left_gridl">
                                        <p class="para1">28 <span>June- 2016</span></p>
                                        <p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a
                                                href="#"><span>comments- 8</span></a></p>
                                        <p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a
                                                href="#"><span>view- 21</span></a></p>
                                    </div>
                                    <div class="agileits_news_grid_left_gridr">
                                        <img src="images/10.jpg" alt=" " class="img-responsive"/>
                                        <h4><a href="single.html">tempora incidunt eius</a></h4>
                                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse
                                            quam nihil molestiae consequatur, vel illum qui dolorem.</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="col-md-6 agileits_news_grid_left">
                                    <div class="agileits_news_grid_left_gridl">
                                        <p class="para1">30 <span>June- 2016</span></p>
                                        <p class="para1"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a
                                                href="#"><span>comments- 5</span></a></p>
                                        <p><i class="glyphicon glyphicon-eye-open" aria-hidden="true"></i><a
                                                href="#"><span>view- 34</span></a></p>
                                    </div>
                                    <div class="agileits_news_grid_left_gridr">
                                        <img src="images/11.jpg" alt=" " class="img-responsive"/>
                                        <h4><a href="single.html">illumqui dolorem eum</a></h4>
                                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse
                                            quam nihil molestiae consequatur, vel illum qui dolorem.</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </li>
                    </ul>
                    <div id="loadMore">Load more</div>
                    <div id="showLess">Show less</div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //news -->
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
</body>
<%@ include file="common_footer.jsp" %>
</html>