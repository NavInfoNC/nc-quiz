<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>四维图新在线笔试系统 beta 1.2</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="../css/prism.css" rel="stylesheet" />
    <style type="text/css">
        .table-hover2>tbody>tr:hover {
            background-color: #fff9d8;
        }
        .table>tbody>tr>td.indent-grid {
            padding-left: 50px;
        }
        .error-answer {
            background-color: #f2dede;
        }
        .correct-answer {
            background-color: #c9e2b3;
        }
        .missed-answer {
            background-color: #ffe5be;
        }
        .question-category {
            color: #ff0000;
        }
        .question-category:before {
            content: "[";
            color: #ff0000;
        }
        .question-category:after {
            content: "]";
            color: #ff0000;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <div class="row">
            <div class="col-md-8" style="padding-top: 30px">
                <h1><span class="text-primary">${viewUserName}</span> 的答卷</h1>
                <p>
                    答题密钥：<kbd>${viewUserToken}</kbd>
                </p>
            </div>
            <div class="col-md-4"><span class="text-danger" style="font-size: 8.5em">${viewUserScore}</span></div>
        </div>
    </div>

    <div class="page-header">
        <h1>总体情况</h1>
    </div>
    <table class="table table-striped table-hover2 table-bordered" style="font-size: 1.2em">
        <thead>
            <tr>
                <th style="width: 50%">答题项目</th>
                <th>得分</th>
            </tr>
        </thead>
        <c:forEach var="c" items="${userDetailScores}" varStatus="s">
        <tr>
            <td class="${c.itemClass} text-primary">${c.itemName}</td>
            <td class="${c.itemClass}"><span class="text-danger">${c.itemScore}</span> / <span class="text-success">${c.itemMaxScore}</span></td>
        </tr>
        </c:forEach>
    </table>
    <div class="col-md-12" style="padding-bottom: 20px">
        <span class="error-answer">&nbsp;&nbsp;&nbsp;&nbsp;</span> 表示这个答案是错误的，但是您选择了它；
        <span class="correct-answer">&nbsp;&nbsp;&nbsp;&nbsp;</span> 表示这个答案是正确的，并且您正确地选择了它；
        <span class="missed-answer">&nbsp;&nbsp;&nbsp;&nbsp;</span> 表示这个答案是正确的，但是您却没有选择它。
    </div>
    <div class="page-header">
        <h1>单项选择题 <small>每题都只有<strong>唯一一个</strong>答案。</small></h1>
    </div>
    <table class="table table-striped table-hover2" style="font-size: 1.2em">
    	<c:forEach var="q" items="${singles}" varStatus="s">
       	<tr>
       		<td class="row">
       			<div class="col-md-12" style="padding-bottom: 20px"><p><strong>第${s.index+1}题：</strong> <span class="question-category">${q.question.categoryName}</span></p>${q.question.title}</div>
       			<c:forEach var="c" items="${q.question.choices}" varStatus="s2">
                <div class="col-md-12 radio ${q.answerClass[s2.index]}">
                    <label><input type="radio" value="${s2.index}" disabled ${q.answerChecked[s2.index]}> ${c.description}</label>
                </div>
                </c:forEach>
                <div class="col-md-12">本题得分：<span style="font-size: 1.2em"><span class="text-danger">${q.score}</span> / <span class="text-success">${q.maxScore}</span></span></div>
       		</td>
       	</tr>
       	</c:forEach>
    </table>

    <div class="page-header">
        <h1>不定项选择题 <small>每题都可能有<strong>一个或多个</strong>答案，注意不是单选题。</small></h1>
    </div>
    <table class="table table-striped table-hover2" style="font-size: 1.2em">
        <c:forEach var="q" items="${multis}" varStatus="s">
       	<tr>
       		<td class="row">
       			<div class="col-md-12" style="padding-bottom: 20px"><p><strong>第${fn:length(singles)+s.index+1}题：</strong> <span class="question-category">${q.question.categoryName}</span></p>${q.question.title}</div>
       			<c:forEach var="c" items="${q.question.choices}" varStatus="s2">
                <div class="col-md-12 checkbox ${q.answerClass[s2.index]}">
                    <label><input type="checkbox" value="${s2.index}" disabled ${q.answerChecked[s2.index]}> ${c.description}</label>
                </div>
                </c:forEach>
                <div class="col-md-12">本题得分：<span style="font-size: 1.2em"><span class="text-danger">${q.score}</span> / <span class="text-success">${q.maxScore}</span></span></div>
       		</td>
       	</tr>
       	</c:forEach>
    </table>

    <div class="page-header">
        <h1>判断题 <small>如果你认为描述是正确的，请在前面的复选框上打勾。</small></h1>
    </div>
    <table class="table table-striped table-hover2" style="font-size: 1.2em">
    	<c:forEach var="q" items="${judgments}" varStatus="s">
        <tr>
            <td class="row">
                <div class="col-md-12 checkbox ${q.answerClass}">
                    <label><input type="checkbox" disabled ${q.answerChecked}>${fn:length(singles)+fn:length(multis)+s.index+1}. <span class="question-category">${q.question.categoryName}</span> ${q.question.title}</label>
                </div>
                <div class="col-md-12">本题得分：<span style="font-size: 1.2em"><span class="text-danger">${q.score}</span> / <span class="text-success">${q.maxScore}</span></span></div>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>

<br>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/prism.js"></script>
</body>
</html>