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
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.get('userList')}" var="ly">
        <tr>
            <td style="text-align:center;">${ly.userid}</td>
            <td style="text-align:center;">${ly.loginname}</td>
            <td style="text-align:center;">${ly.username}</td>
            <td style="text-align:center;">${ly.secret}</td>
            <td style="text-align:center;">${ly.phone}</td>
            <td style="text-align:center;">${ly.sex}</td>
            <td style="text-align:center;">${ly.email}</td>
            <td style="text-align:center;">
                <input type="submit" value="修改" class="btn btn-info"
                       onclick="update('${ly.userid}','${ly.loginname}','${ly.username}','${ly.secret}',
                               '${ly.phone}','${ly.sex}','${ly.email}')">
                <input type="button" class="btn btn-info"
                       onclick="delcfm('deleteUserAction?userEntity.userid=${ly.userid}')"
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

    function update(userid, loginname, username, secret, phone, sex, email) {
        $('#userid').val(userid);
        $('#loginname').val(loginname);
        $('#username').val(username);
        $('#secret').val(secret);
        $('#phone').val(phone);
        $('#sex').val(sex);
        $('#email').val(email);
        $('#myModal').modal();
    }
</script>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">输入更改的信息</h4>
            </div>
            <form action="updateUserAction" method="post">
                <div class="modal-body">
                    <p>用户编号</p>
                    <input type="text" name="userEntity.userid" class="form-control" id="userid">
                    <p>用户登录名</p>
                    <input type="text" name="userEntity.loginname" class="form-control" id="loginname">
                    <p>用户名</p>
                    <input type="text" name="userEntity.username" class="form-control" id="username">
                    <p>密码</p>
                    <input type="text" name="userEntity.secret" class="form-control" id="secret">
                    <p>电话</p>
                    <input type="text" name="userEntity.phone" class="form-control" id="phone">
                    <p>性别</p>
                    <input type="text" name="userEntity.sex" class="form-control" id="sex">
                    <p>邮箱</p>
                    <input type="text" name="userEntity.email" class="form-control" id="email">
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    <input class="btn btn-primary" type="submit" value="提交"/>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
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

