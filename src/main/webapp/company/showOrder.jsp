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

<s:set var="page" value="#page"/>
<div id="show">
	<div id="info">
		<table id="table" class="table table-hover table-striped" >
			<tr>
				<td>编号</td>
				<td>${sessionScope.get("b").get(param.page).orderid}</td>
			</tr>
			<tr>
				<td>接单公司</td>
				<td>${sessionScope.get("b").get(param.page).companyname}</td>
			</tr>
			<tr>
				<td>出发地</td>
				<td>${sessionScope.get("b").get(param.page).departure}</td>
			</tr>
			<tr>
				<td>目的地</td>
				<td>${sessionScope.get("b").get(param.page).destination}</td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td>${sessionScope.get("b").get(param.page).time}</td>
			</tr>
			<tr>
				<td>发货时间</td>
				<td>${sessionScope.get("b").get(param.page).deliverytime}</td>
			</tr>
			<tr>
				<td>完成时间</td>
				<td>${sessionScope.get("b").get(param.page).finishtime}</td>
			</tr>
			<tr>
				<td>货物数量</td>
				<td>${sessionScope.get("b").get(param.page).amount}</td>
			</tr>
			<tr>
				<td>货物重量</td>
				<td>${sessionScope.get("b").get(param.page).itemsize}</td>
			</tr>
			<tr>
				<td>期望取件时间</td>
				<td>${sessionScope.get("b").get(param.page).availabletime}</td>
			</tr>
			<tr>
				<td>订单价格</td>
				<td>${sessionScope.get("b").get(param.page).price}</td>
			</tr>
			<tr>
				<td>订单状态</td>
				<td>${sessionScope.get("b").get(param.page).status}</td>
			</tr>
			<tr id="evaluation1">
				<td>评价</td>
				<td>${sessionScope.get("b").get(param.page).evaluation}</td>
			</tr>
			<tr id="pic">
				<td>图片</td>
				<td><img src="/uploads/${sessionScope.get("b").get(param.page).pic}" alt="" width="300px"/></td>
			</tr>
		</table>
		<div style="text-align:center;">
			<input type="button" onclick="window.location='/company/showOrder.jsp?page=${param.page-1}'" value="上一单" id="left" class="btn btn-primary">
			<input type="button" onclick="window.location='/company/showOrder.jsp?page=${param.page+1}'" value="下一单" id="right" class="btn btn-primary">
			当前第${param.page+1}页，总共${sessionScope.get("b").size()}页
			<input type="text" id="goto" title="" style="width: 50px">&nbsp;&nbsp;<input type="button" onclick="goTo()" value="跳转" class="btn btn-success">
			<input type="button" onclick="acceptOrder()" value="接受订单" class="btn btn-primary" />
			<input type="button" onclick="deliveried()" value="订单送达" class="btn btn-primary"/>
			<input type="button" onclick="editable()" value="修改订单" class="btn btn-primary"/>
			<input type="button" id="evaluation"
				   onclick="window.location.href='../evaluation/addEvaluation.jsp?orderid=${sessionScope.get("b").get(param.page).orderid}'"
				   value="评价" style="display: none" class="btn btn-primary">
		</div>
		<%--修改订单弹出窗口开始--%>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
								class="sr-only">Close</span></button>
						<h4 class="modal-title">可修改信息</h4>
					</div>
					<form action="../updateOrder?orderid=${sessionScope.get("b").get(param.page).orderid}" method="post">
						<div class="modal-body">
							<p>货物数量</p>
							<input type="text" name="orderEntity.itemamount" class="form-control"
								   value="${sessionScope.get("b").get(param.page).amount}">
							<p>货物重量</p>
							<input type="text" name="orderEntity.itemsize" class="form-control"
								   value="${sessionScope.get("b").get(param.page).itemsize}">
							<p>期望时间</p>
							<input type="datetime-local" name="time" value="${sessionScope.get("b").get(param.page).availabletimestart}"/>~
							<input type="datetime-local" name="time" value="${sessionScope.get("b").get(param.page).availabletimeend}"/>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
							<input class="btn btn-primary" type="submit" value="提交"/>
						</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div>
		<%--修改订单弹出窗口结束--%>
	</div>
</div>
<script>
    function acceptOrder() {
        var status = "${sessionScope.get("b").get(param.page).status}";
        if (status === "等待收件") {
            location.href = "preAcceptOrder?orderid=${sessionScope.get("b").get(param.page).orderid}";
        } else {
            alert('包裹未处于可接受订单状态！');
        }
    }

    function deliveried() {
        var status = "${sessionScope.get("b").get(param.page).status}";
        if (status === "已发货") {
            location.href = 'finishDelivery?orderid=${sessionScope.get("b").get(param.page).orderid}';
        } else {
            alert('包裹未处于可送达状态！');
        }
    }
    function goTo() {
        var p = document.getElementById("goto");
        var txt = p.value;
        txt = txt - 1;
        window.location = "/company/showOrder.jsp?page=" + txt + "";
    }
    function editable() {
        var status = "${sessionScope.get("b").get(param.page).status}";
        if (status !== "等待收件") {
            alert('包裹已发货，无法再修改信息');
        } else {
            $('#myModal').modal();
        }
    }
</script>
<script>
    var status = "${sessionScope.get("b").get(param.page).status}";
    if (status !== "已评价") {
        var evaluation1 = document.getElementById("evaluation1");
        var p = document.getElementById("pic");
        evaluation1.style.display = "none";
        p.style.display = "none";
    }
    if (status === "已送达") {
        var submit = document.getElementById("finish");
        submit.style.display = "inline";
    }
    if (status === "已完成") {
        var evaluation = document.getElementById("evaluation");
        evaluation.style.display = "inline";
    }
</script>
</body>
</html>
