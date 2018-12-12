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
        <th style="text-align:center;">密码</th>
        <th style="text-align:center;">公司名称</th>
        <th style="text-align:center;">地址</th>
        <th style="text-align:center;">电话</th>
        <th style="text-align:center;">邮箱</th>
        <th style="text-align:center;">操作</th>
        <th style="text-align:center;">重置</th>
    </tr>
        <s:iterator value="companyEntity" var="ly">
        <form method="post" action="updateCompanyAction" onsubmit="return check()">
                <td><input type="text" class="form-control" name="companyEntity.companyid" value="${ly.companyid}" readOnly="true" size="10"></td>
                <td><input type="text" class="form-control" name="companyEntity.loginname" value="${ly.loginname}" size="10"></td>
                <td><input type="text" class="form-control" name="companyEntity.secret" value="${ly.secret}" size="10"></td>
                <td><input type="text" class="form-control" name="companyEntity.companyname" value="${ly.companyname}" readOnly="true" size="10"></td>
                <td><input type="text" class="form-control" name="companyEntity.address" value="${ly.address}" size="10"></td>
                <td><input type="text" class="form-control" name="companyEntity.phone" value="${ly.phone}" size="10"></td>
                <td><input type="text" class="form-control" name="companyEntity.email" value="${ly.email}" size="10"></td>
                <td><input type="submit" value="修改" class="btn btn-info"></td>
                <td><input type="reset" value="重置" class="btn btn-info"></td>
            </tr>
        </form>
        </s:iterator>
</table>
<script>
    function check(){
        var gnl=confirm("确定要提交?");
        if (gnl==true){
            return true;
        }else{
            return false;
        }
    }
</script>
</body>
</html>
