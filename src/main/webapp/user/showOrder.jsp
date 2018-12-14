<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看历史订单</title>
	<script src="../js/jquery.min.js"></script>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<script src="../js/bootstrap.min.js"></script>

</head>
<body>
<%--<s:param>--%>
	<%--<s:set var="page" value="page" scope="page"/>--%>
	<%--<s:iterator value="list" status="rows" var="order">--%>
		<%--<s:if test="#rows.index=page">--%>
			<%--<s:set var="b" value="#order" scope="page"/>--%>
			<%--<s:iterator value="evaluationEntity" status="eva" var="evaluation">--%>
				<%--<s:if test="#evaluation.userid=#order.userid">--%>
					<%--<s:set var="e" value="#evaluation" scope="page"/>--%>
				<%--</s:if>--%>
			<%--</s:iterator>--%>
		<%--</s:if>--%>
	<%--</s:iterator>--%>
<%--</s:param>--%>
<div id="show">
    <div id="info">
        <form action="EditOrder?id=${b.orderid}" method="post" id="form">
            <table id="table" class="table table-hover table-striped">
                <tr>
                    <td>编号</td>
                    <td>${b.orderid}</td>
                </tr>
                <tr>
                    <td>接单公司</td>
                    <td>${b.companyname}</td>
                </tr>
                <tr>
                    <td>出发地</td>
                    <td>${b.departure}</td>
                </tr>
                <tr>
                    <td>目的地</td>
                    <td>${b.destination}</td>
                </tr>
                <tr>
                    <td>创建时间</td>
                    <td>${b.time}</td>
                </tr>
                <tr>
                    <td>发货时间</td>
                    <td>${b.deliverytime}</td>
                </tr>
                <tr>
                    <td>完成时间</td>
                    <td>${b.finishtime}</td>
                </tr>
                <tr>
                    <td>货物数量</td>
                    <td>${b.amount}</td>
                </tr>
                <tr>
                    <td>货物重量</td>
                    <td>${b.itemsize}</td>
                </tr>
                <tr>
                    <td>期望取件时间</td>
                    <td>${b.availabletime}</td>
                </tr>
                <tr>
                    <td>订单价格</td>
                    <td>${b.price}</td>
                </tr>
                <tr>
                    <td>订单状态</td>
                    <td>${b.status}</td>
                </tr>
                <tr id="evaluation1">
                    <td>评价</td>
                    <td>${b.evaluation}</td>
                </tr>
				<tr>
					<td style="text-align:center;" colspan="2">
						<input type="button" onclick="editable()" value="修改订单"  class="btn btn-primary"/>
						<input type="button" onclick="deleteable()" value="删除订单"  class="btn btn-primary"/>
						<input type="button" onclick="window.location.href='EditOrder?id=${b.orderid}'" value="确认收货"
							   style="display: none" id="finish"  class="btn btn-primary"/>
						<input type="button"
							   onclick="window.location.href='../evaluation/addEvaluation.jsp?orderid=${b.orderid}&companyid=${b.companyid}'"
							   value="评价" style="display: none" class="btn btn-primary">
					</td>
				</tr>
            </table>
            <input type="submit" value="提交" style="display: none" id="submit"  class="btn btn-primary">
        </form>
        </div>
</div>
<script>
    function editable() {
        var status = "${b.status}";
        if (status == "等待收件") {
            var submit = document.getElementById("submit");
            submit.style.display = "inline";
            document.getElementById("destination").readOnly = false;
            document.getElementById("amount").readOnly = false;
            document.getElementById("itemSize").readOnly = false;
            document.getElementById("availableTime").readOnly = false;
            document.getElementById("availableTime1").readOnly = false;
        } else {
            alert('包裹已发货，无法再修改信息');
        }
    }

    function deleteable() {
        var status = "${b.status}";
        if (status == "等待收件") {
            location.href = "DeleteOrder?id=${b.orderid}";
        } else {
            alert('包裹已发货，无法再删除订单');
        }
    }
</script>
<script>
    var status = "${b.status}";
    if(status!="已评价"){
        var evaluation1=document.getElementById("evaluation1");
        evaluation1.style.display="none";
        <%--evaluation=document.getElementById("evaluationtxt");--%>
        <%--evaluation1.value="${e.content}";--%>
    }
    if (status == "已送达") {
        var submit = document.getElementById("finish");
        submit.style.display = "inline";
    }
    if (status == "已完成") {
        var evaluation = document.getElementById("evaluation");
        evaluation.style.display = "inline";
    }
    <%--if (!${page}) {--%>
        <%--var left = document.getElementById("left");--%>
        <%--left.style.display = "none";--%>
    <%--}--%>
    <%--var size = parseFloat("${res.size()}");--%>
    <%--var page = parseFloat("${page}");--%>
    <%--if (page == size - 1) {--%>
        <%--var right = document.getElementById("right");--%>
        <%--right.style.display = "none";--%>
    <%--}--%>
</script>
</body>
</html>
