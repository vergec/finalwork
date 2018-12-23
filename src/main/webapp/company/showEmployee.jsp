<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page isELIgnored="false" %>

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
    </tr>
    <s:iterator value="employeeEntities" var="ly">
            <tr>
            <td style="text-align:center;">${ly.employeeid}</td>
            <td style="text-align:center;">${ly.name}</td>
            <td style="text-align:center;">${ly.position}</td>
            <td style="text-align:center;">${ly.phone}</td>
            <td style="text-align:center;">
                <input type="button" value="修改" class="btn btn-info" onclick="update('${ly.employeeid}','${ly.name}','${ly.position}','${ly.phone}')">
                <input type="button" class="btn btn-info"
                       onclick="delcfm('deleteEmployeeAction?employeeEntity.employeeid=${ly.employeeid}')"
                       value="删除">
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

    function update(employeeid,name,position,phone) {
        $('#employeeid').val(employeeid);
        $('#name').val(name);
        $('#position').val(position);
        $('#phone').val(phone);
        $('#myModal').modal();
    }
    // function check(){
    //     var gnl=confirm("确定要提交?");
    //     if (gnl==true){
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }

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
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">输入更改的信息</h4>
            </div>
            <form action="updateEmployeeAction" method="post">
                <div class="modal-body">
                    <p>员工编号</p>
                    <input type="text" class="form-control" id="employeeid" name="employeeEntity.employeeid">
                    <p>员工姓名</p>
                    <input type="text" class="form-control" id="name" name="employeeEntity.name">
                    <p>员工职位</p>
                    <input type="text" class="form-control" id="position" name="employeeEntity.position">
                    <p>员工电话</p>
                    <input type="text" class="form-control" id="phone" name="employeeEntity.phone">
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
