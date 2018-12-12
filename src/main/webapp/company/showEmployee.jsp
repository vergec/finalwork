<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
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
        <th style="text-align:center;">员工编号</th>
        <th style="text-align:center;">员工姓名</th>
        <th style="text-align:center;">员工职位</th>
        <th style="text-align:center;">员工电话</th>
        <th style="text-align:center;">操作</th>
        <th style="text-align:center;">重置</th>
    </tr>
    <s:iterator value="employeeEntities" var="ly">
        <form id="test_form" method="post" action="updateEmployeeAction" onsubmit="return check()">
            <td><input type="text" class="form-control" name="employeeEntity.employeeid" value="${ly.employeeid}"></td>
            <td><input type="text" class="form-control" name="employeeEntity.name" value="${ly.name}"></td>
            <td><input type="text" class="form-control" name="employeeEntity.position" value="${ly.position}"></td>
            <td><input type="text" class="form-control" name="employeeEntity.phone" value="${ly.phone}"></td>
            <td style="text-align:center;">
                <input type="submit" value="修改" class="btn btn-info">
                <input type="button" class="btn btn-info"
                       onclick="delcfm('deleteEmployeeAction?employeeEntity.employeeid=${ly.employeeid}')"
                       value="删除">
            </td>
            <td style="text-align:center;"><input type="reset" class="btn btn-info" value="重置"></td>
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
