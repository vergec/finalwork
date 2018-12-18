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
        <th style="text-align:center;">公司编号</th>
        <th style="text-align:center;">登录名</th>
        <%--<th style="text-align:center;">密码</th>--%>
        <th style="text-align:center;">公司名称</th>
        <th style="text-align:center;">地址</th>
        <th style="text-align:center;">电话</th>
        <th style="text-align:center;">邮箱</th>
        <th style="text-align:center;">操作</th>
    </tr>
        <s:iterator value="companyEntity" var="ly">
            <tr>
                <td style="text-align:center;">${ly.companyid}</td>
                <td style="text-align:center;">${ly.companyname}</td>
                <td style="text-align:center;">${ly.loginname}</td>
                <%--<td style="text-align:center;">${ly.secret}</td>--%>
                <td style="text-align:center;">${ly.address}</td>
                <td style="text-align:center;">${ly.phone}</td>
                <td style="text-align:center;">${ly.email}</td>
                <td style="text-align:center;">
                    <input type="submit" value="修改" class="btn btn-info"  data-toggle="modal" data-target="#myModal">
                </td>
                </form>
            </tr>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title">输入更改的信息</h4>
                        </div>
                        <form action="../updateCompanyAction" method="post">
                            <div class="modal-body">
                                <p>公司编号</p>
                                <input type="text" name="companyEntity.companyid" class="form-control" value="${ly.companyid}" readonly>
                                <p>公司名称</p>
                                <input type="text" name="companyEntity.companyname" class="form-control" value="${ly.companyname}" readonly>
                                <p>登录名</p>
                                <input type="text" name="companyEntity.loginname" class="form-control" value="${ly.loginname}">
                                <p>密码</p>
                                <input type="password" name="companyEntity.secret" class="form-control" value="${ly.secret}">
                                <p>地址</p>
                                <input type="text" name="companyEntity.address" class="form-control" value="${ly.address}">
                                <p>电话</p>
                                <input type="text" name="companyEntity.phone" class="form-control" value="${ly.phone}">
                                <p>邮箱</p>
                                <input type="text" name="companyEntity.email" class="form-control" value="${ly.email}">
                            </div>
                            <div class="modal-footer">
                                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                                <input class="btn btn-primary" type="submit" value="提交"/>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        </s:iterator>
</table>
</body>
</html>
