<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>四维图新在线笔试系统 beta 1.2</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <style type="text/css">
        .table-hover2>tbody>tr:hover
        {
            background-color: #fff9d8;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>四维图新笔试系统<span class="text-primary">管理后台</span> <small>beta 1.2</small></h1>
        <p>
            总觉得这个地方应该写点什么...
        </p>
    </div>

	<c:if test="${!empty managerMsg}">
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong>提示：</strong> ${managerMsg}
    </div>
    <c:set var="managerMsg" scope="session" value=""/>
    </c:if>

    <div class="page-header">
        <h1>口令管理 <small>当前共有 <span class="text-danger">${fn:length(tokenStates)}</span> 个口令</small></h1>
    </div>
    <table class="table table-striped table-hover2" style="font-size: 1.2em">
    	<thead>
        <tr>
            <th>序号</th>
            <th>口令</th>
            <th>对应用户</th>
            <th>当前状态</th>
            <th>得分</th>
        </tr>
        </thead>
        <c:forEach var="q" items="${tokenStates}" varStatus="s">
        <tr>
            <td>${s.index+1}</td>
            <td>${q.tokenHtml}</td>
            <td>${q.userName}</td>
            <td class="${q.stateClass}">${q.state}</td>
            <td>${q.score}</td>
        </tr>        
        </c:forEach>
    </table>

    <div class="page-header">
        <h1>其它操作 <small>请谨慎处理，你最好知道你自己在干什么</small></h1>
    </div>
    <div class="col-md-12">
        <form action="reloadQuestions" method="POST" class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">重新生成的 token 条数：</label>
                <input type="text" class="form-control" id="exampleInputName2" name="tokenCount" placeholder="token 条数" value="200">
            </div>
            <button type="submit" class="btn btn-primary" onclick="return confirm('这个操作会导致您丢失目前为止的所有答题情况，您确定要继续吗？');">重新初始化 tokens</button>
        </form>
    </div>
</div>

<br>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>