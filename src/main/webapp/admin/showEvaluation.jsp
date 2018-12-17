<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/12/16
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="../js/jquery.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<table id="table" class="table table-hover table-striped">
    <thead>
    <th style="text-align:center;">评价编号</th>
    <th style="text-align:center;">用户编号</th>
    <th style="text-align:center;">公司编号</th>
    <th style="text-align:center;">订单编号</th>
    <th style="text-align:center;">时间</th>
    <th style="text-align:center;">标题</th>
    <th style="text-align:center;">内容</th>
    <th style="text-align:center;">图片</th>
    <th style="text-align:center;">操作</th>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.get('evaluationList')}" var="ly">
        <tr>
            <td style="text-align:center;">${ly.evaluationid}</td>
            <td style="text-align:center;">${ly.userid}</td>
            <td style="text-align:center;">${ly.companyid}</td>
            <td style="text-align:center;">${ly.orderid}</td>
            <td style="text-align:center;">${ly.time}</td>
            <td style="text-align:center;">${ly.title}</td>
            <td style="text-align:center;">${ly.content}</td>
            <td><img src="/uploads/${ly.photo1}" alt="" width="250px"/></td>
            <td style="text-align:center;">
                <input type="button" class="btn btn-info"
                       onclick="delcfm('deleteEvaluationAction?evaluationEntity.evaluationid=${ly.evaluationid}')"
                       value="删除">
            </td>
        </tr>
    </c:forEach>
    </tbody>
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
