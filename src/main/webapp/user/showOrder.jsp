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
<div id="show">
	<div id="info">
			<table id="table" class="table table-hover table-striped">
				<tr>
					<td>编号</td>
					<td>${sessionScope.get("b").orderid}</td>
				</tr>
				<tr>
					<td>接单公司</td>
					<td>${sessionScope.get("b").companyname}</td>
				</tr>
				<tr>
					<td>出发地</td>
					<td>${sessionScope.get("b").departure}</td>
				</tr>
				<tr>
					<td>目的地</td>
					<td>${sessionScope.get("b").destination}</td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td>${sessionScope.get("b").time}</td>
				</tr>
				<tr>
					<td>发货时间</td>
					<td>${sessionScope.get("b").deliverytime}</td>
				</tr>
				<tr>
					<td>完成时间</td>
					<td>${sessionScope.get("b").finishtime}</td>
				</tr>
				<tr>
					<td>货物数量</td>
					<td>${sessionScope.get("b").amount}</td>
				</tr>
				<tr>
					<td>货物重量</td>
					<td>${sessionScope.get("b").itemsize}</td>
				</tr>
				<tr>
					<td>期望取件时间</td>
					<td>${sessionScope.get("b").availabletime}</td>
				</tr>
				<tr>
					<td>订单价格</td>
					<td>${sessionScope.get("b").price}</td>
				</tr>
				<tr>
					<td>订单状态</td>
					<td>${sessionScope.get("b").status}</td>
				</tr>
				<tr id="evaluation1">
					<td>评价</td>
					<td>${sessionScope.get("b").evaluation}</td>
				</tr>
				<tr id="pic">
					<td>图片</td>
					<td><img src="/uploads/${sessionScope.get("b").pic}" alt="" width="300px"/></td>
				</tr>
			</table>
			<div style="text-align:center;">
				<input type="button" onclick="editable()" value="修改订单" class="btn btn-primary" data-toggle="modal" data-target="#myModal"/>
				<input type="button" onclick="deleteable()" value="删除订单" class="btn btn-primary"/>
				<input type="button" onclick="window.location.href='EditOrder?id=${sessionScope.get("b").orderid}'" value="确认收货"
					   style="display: none" id="finish" class="btn btn-primary"/>
				<input type="button" id="evaluation"
					   onclick="window.location.href='../evaluation/addEvaluation.jsp?orderid=${sessionScope.get("b").orderid}'"
					   value="评价" style="display: none" class="btn btn-primary">
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
							<h4 class="modal-title">提问</h4>
						</div>
						<form action="../updateOrder?orderid=${sessionScope.get("b").orderid}" method="post">
							<div class="modal-body">
								<p>货物数量</p>
								<input type="text" name="orderEntity.itemamount" class="form-control" value="${sessionScope.get("b").amount}">
								<p>货物重量</p>
								<input type="text" name="orderEntity.itemsize" class="form-control" value="${sessionScope.get("b").itemsize}">
								<p>问题描述</p>
								<input type="datetime-local" name="time" value="${b.availabletimestart}"/>~
								<input type="datetime-local" name="time" value="${b.availabletimeend}"/>
							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
								<input class="btn btn-primary" type="submit" value="提交"/>
							</div>
						</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div>
	</div>
</div>
<script>
    function editable() {
        var status = "${sessionScope.get("b").status}";
        if (status === "等待收件") {
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
        var status = "${sessionScope.get("b").status}";
        if (status === "等待收件") {
            location.href = "../deleteOrder?orderid=${sessionScope.get("b").orderid}";
        } else {
            alert('包裹已发货，无法再删除订单');
        }
    }
</script>
<script>
    var status = "${sessionScope.get("b").status}";
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
