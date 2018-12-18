<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/6/4
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <script src="../js/jquery.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<table class="table table-hover table table-striped">
    <tr>
        <th style="text-align:center;">车辆编号</th>
        <th style="text-align:center;">司机编号</th>
        <th style="text-align:center;">车辆类型</th>
        <th style="text-align:center;">车牌号码</th>
        <th style="text-align:center;">操作</th>
    </tr>
    <s:iterator value="carEntities" var="ly">
        <tr>
            <td style="text-align:center;">${ly.carid}</td>
            <td style="text-align:center;">${ly.driverid}</td>
            <td style="text-align:center;">${ly.kind}</td>
            <td style="text-align:center;">${ly.number}</td>
            <td style="text-align:center;">
                <input type="submit" value="修改" class="btn btn-info" onclick="update('${ly.carid}','${ly.driverid}','${ly.kind}','${ly.number}')">
                <input type="button"
                       onclick="delcfm('deleteCarAction?carEntity.carid=${ly.carid}')"
                       value="删除" class="btn btn-info">
            </td>
        </tr>
    </s:iterator>
</table>
<script>
    function delcfm(url) {
        $('#url').val(url);//给会话中的隐藏属性URL赋值
        $('#delcfmModel').modal();
    }

    function urlSubmit() {
        var url = $.trim($("#url").val());//获取会话中的隐藏属性URL
        window.location.href = url;
    }

    function update(carid,driverid,kind,number) {
        $('#carid').val(carid);
        $('#driverid').val(driverid);
        $('#kind').val(kind);
        $('#number').val(number);
        $('#myModal').modal();
    }
</script>
<!-- 信息删除确认 -->
<div class="modal fade" id="delcfmModel">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title">提示信息</h4>
            </div>
            <div class="modal-body">
                <p>您确认要删除吗？</p>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="url"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">输入更改的信息</h4>
            </div>
            <form action="../updateCarAction" method="post">
                <div class="modal-body">
                    <p>车辆编号</p>
                    <input type="text" class="form-control" name="carEntity.carid" id="carid" readonly>
                    <p>司机编号</p>
                    <input type="text" class="form-control" name="carEntity.driverid" id="driverid">
                    <p>车辆类型</p>
                    <input type="text" class="form-control" name="carEntity.kind" id="kind">
                    <p>车牌号码</p>
                    <input type="text" class="form-control" name="carEntity.number" id="number">
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    <input class="btn btn-primary" type="submit" value="提交"/>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</body>
</html>

