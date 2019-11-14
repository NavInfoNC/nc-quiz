<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>四维图新在线笔试系统 beta 1.2</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/prism.css" rel="stylesheet" />
    <style type="text/css">
        .table-hover2 td:hover {
            background-color: #fff9d8;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>四维图新在线笔试系统 beta 1.2</h1>
        <p>
            欢迎 <span class="text-primary">${loginYudukiUser}</span>，本套试卷一共有 <span class="text-danger">${fn:length(singles)}</span> 道单选题，
            <span class="text-danger">${fn:length(multis)}</span> 道多选题，
            <span class="text-danger">${fn:length(judgments)}</span> 道判断题，祝您马到成功！
        </p>
    </div>

    <form action="submit" method="POST">
        <div class="page-header">
            <h1>单项选择题 <small> 每题都只有<strong>唯一一个</strong>答案。</small></h1>
        </div>
        <table class="table table-striped table-hover2" style="font-size: 1.2em">
        	<c:forEach var="q" items="${singles}" varStatus="s">
        	<tr>
        		<td class="row">
        			<div class="col-md-12" style="padding-bottom: 20px"><p><strong>第${s.index+1}题：</strong></p>${q.title}</div>
        			<c:forEach var="c" items="${q.choices}" varStatus="s2">
                    <div class="col-md-12 radio">
                        <label><input type="radio" name="S${s.index+1}" value="${s2.index}"> ${c.description}</label>
                    </div>
                    </c:forEach>
        		</td>
        	</tr>
        	</c:forEach>
        </table>

        <div class="page-header">
            <h1>不定项选择题 <small> 每题都可能有<strong>一个或多个</strong>答案，注意不是单选题。</small></h1>
        </div>
        <table class="table table-striped table-hover2" style="font-size: 1.2em">
        	<c:forEach var="q" items="${multis}" varStatus="s">
            <tr>
                <td class="row">
                    <div class="col-md-12" style="padding-bottom: 20px"><p><strong>第${fn:length(singles)+s.index+1}题：</strong></p>${q.title}</div>
                    <c:forEach var="c" items="${q.choices}" varStatus="s2">
                    <div class="col-md-12 checkbox">
                        <label><input type="checkbox" name="M${s.index+1}" value="${s2.index}"> ${c.description}</label>
                    </div>
                    </c:forEach>
                </td>
            </tr>
            </c:forEach>
        </table>

        <div class="page-header">
            <h1>判断题 <small> 如果你认为描述是正确的，请在前面的复选框上打勾。</small></h1>
        </div>
        <table class="table table-striped table-hover2" style="font-size: 1.2em">
        	<c:forEach var="q" items="${judgments}" varStatus="s">
            <tr>
                <td class="row">
                    <div class="col-md-12 checkbox">
                        <label><input type="checkbox" name="J${s.index+1}" value="T">${fn:length(singles)+fn:length(multis)+s.index+1}. ${q.title}</label>
                    </div>
                </td>
            </tr>
            </c:forEach>
        </table>

        <div class="form-group" style="margin-bottom: 20px">
            <div class="col-md-12" style="text-align: center">
                <button type="submit" class="btn btn-primary btn-block btn-lg" onclick="return confirm('一旦提交将无法继续答题，确定要提交吗？')">提交答案</button>
            </div>
        </div>
        <input type="hidden" name="token" value="${loginYudukiToken}"/>
    </form>
</div>

<br>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/prism.js"></script>
</body>
</html>