<%--
  Created by IntelliJ IDEA.
  User: KevinWang
  Date: 2018/12/15
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored="false" %>

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
    <th style="text-align:center;">公司编号</th>
    <th style="text-align:center;">公司名称</th>
    <th style="text-align:center;">登录名</th>
    <th style="text-align:center;">密码</th>
    <th style="text-align:center;">地址</th>
    <th style="text-align:center;">电话</th>
    <th style="text-align:center;">邮箱</th>
    <th style="text-align:center;">操作</th>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.get('companyList')}" var="ly">
        <tr>
                <td style="text-align:center;">${ly.companyid}</td>
                <td style="text-align:center;">${ly.companyname}</td>
                <td style="text-align:center;">${ly.loginname}</td>
                <td style="text-align:center;">${ly.secret}</td>
                <td style="text-align:center;">${ly.address}</td>
                <td style="text-align:center;">${ly.phone}</td>
                <td style="text-align:center;">${ly.email}</td>
                <td style="text-align:center;">
                    <input type="submit" value="修改" class="btn btn-info"
                           onclick="update('${ly.companyid}','${ly.companyname}','${ly.loginname}','${ly.secret}',
                                   '${ly.address}','${ly.phone}','${ly.email}')">
                    <input type="button" class="btn btn-info"
                           onclick="delcfm('../deleteCompanyAction?companyEntity.companyid=${ly.companyid}')"
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
    function update(companyid,companyname,loginname,secret,address,phone,email) {
        $('#companyid').val(companyid);
        $('#companyname').val(companyname);
        $('#loginname').val(loginname);
        $('#secret').val(secret);
        $('#address').val(address);
        $('#phone').val(phone);
        $('#email').val(email);
        $('#myModal').modal();
    }
</script>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">输入更改的信息</h4>
            </div>
            <form action="../adminUpdateCompanyAction" method="post">
                <div class="modal-body">
                    <p>公司编号</p>
                    <input type="text" name="companyEntity.companyid" class="form-control" id="companyid">
                    <p>公司名称</p>
                    <input type="text" name="companyEntity.companyname" class="form-control" id="companyname">
                    <p>登录名</p>
                    <input type="text" name="companyEntity.loginname" class="form-control" id="loginname">
                    <p>密码</p>
                    <input type="text" name="companyEntity.secret" class="form-control" id="secret">
                    <p>地址</p>
                    <input type="text" name="companyEntity.address" class="form-control" id="address">
                    <p>电话</p>
                    <input type="text" name="companyEntity.phone" class="form-control" id="phone">
                    <p>邮箱</p>
                    <input type="text" name="companyEntity.email" class="form-control" id="email">
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

