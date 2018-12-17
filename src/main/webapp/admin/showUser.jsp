<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/12/16
  Time: 17:13
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
    <th style="text-align:center;">用户编号</th>
    <th style="text-align:center;">用户登陆名</th>
    <th style="text-align:center;">用户名</th>
    <th style="text-align:center;">密码</th>
    <th style="text-align:center;">电话</th>
    <th style="text-align:center;">性别</th>
    <th style="text-align:center;">email</th>
    <th style="text-align:center;">操作</th>
    <th style="text-align:center;">重置</th>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.get('userList')}" var="ly">
        <tr>
            <form action="../adminUpdateCompanyAction" method="post" onsubmit="return check()">
                <td style="text-align:center;"><input name="" value="${ly.userid}" class="form-control" size="10"></td>
                <td style="text-align:center;"><input name="" value="${ly.loginname}" class="form-control" size="10"></td>
                <td style="text-align:center;"><input name="" value="${ly.username}" class="form-control" size="10"></td>
                <td style="text-align:center;"><input name="" value="${ly.secret}" class="form-control" size="10"></td>
                <td style="text-align:center;"><input name="" value="${ly.phone}" class="form-control" size="10"></td>
                <td style="text-align:center;"><input name="" value="${ly.sex}" class="form-control" size="10"></td>
                <td style="text-align:center;"><input name="" value="${ly.email}" class="form-control" size="10"></td>
                <td style="text-align:center;">
                    <input type="submit" value="修改" class="btn btn-info">
                    <input type="button" class="btn btn-info"
                           onclick="delcfm('../deleteCompanyAction?companyEntity.companyid=${ly.userid}')"
                           value="删除">
                </td>
                <td style="text-align:center;"><input type="reset" class="btn btn-info" value="重置"></td>
            </form>
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

