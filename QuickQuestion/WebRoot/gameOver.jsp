<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>四维图新在线笔试系统 beta 1.2</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">您已成功提交您的答案</h4>
            </div>
            <div class="modal-body">
                <p>
                    亲爱的 <span class="text-primary">${loginYudukiUser}</span>，您已经成功提交您的答卷，
                    请耐心等待考官阅卷，祝您身体愉快！
                </p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $('#myModal').modal({
        keyboard: false,
        backdrop: "static",
        show: true
    });
</script>
</body>
</html>