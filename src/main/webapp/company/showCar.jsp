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
        <th style="text-align:center;">重置</th>
    </tr>
    <s:iterator value="carEntities" var="ly">
        <form method="post" action="updateCarAction" onsubmit="return check()">
                <td><input type="text" class="form-control" name="carEntity.carid" value="${ly.carid}"></td>
                <td><input type="text" class="form-control" name="carEntity.driverid" value="${ly.driverid}"></td>
                <td><input type="text" class="form-control" name="carEntity.kind" value="${ly.kind}"></td>
                <td><input type="text" class="form-control" name="carEntity.number" value="${ly.number}"></td>
                <td>
                    <input type="submit" value="修改" class="btn btn-info">
                    <input type="button"
                           onclick="delcfm('deleteCarAction?carEntity.carid=${ly.carid}')"
                           value="删除" class="btn btn-info">
                </td>
                <td><input type="reset" value="重置" class="btn btn-info"></td>
            </tr>
        </form>
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
    function check(){
        var gnl=confirm("确定要提交?");
        if (gnl==true){
            return true;
        }else{
            return false;
        }
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
</body>
</html>

