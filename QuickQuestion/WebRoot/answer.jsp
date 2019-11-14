<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>金辉测试系统参考答案，没有略</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style type="text/css">
        .table-hover2 td:hover
        {
            background-color: #fff9d8;
        }
        .error-answer
        {
            background-color: #f2dede;
        }
        .correct-answer
        {
            background-color: #c9e2b3;
        }
        .missed-answer
		{
			background-color: #FFCC99;
		}
		.question-category
		{
			color: #ff0000;
		}
		.question-category:before
		{
			content: "[";
			color: #ff0000;
		}
		.question-category:after
		{
			content: "]";
			color: #ff0000;
		}
    </style>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <div class="row">
            <div class="col-md-8" style="text-align: right; padding-top: 80px">
                <p>您的得分为:</p>
                <p>恭喜您！您已经打败了全组 <span style="color:orange">1%</span> 的用户！</p>
            </div>
            <div class="co-md-4" style="text-align: center">
                <span style="font-size: 10em; color: red">${score}</span>
            </div>
        </div>
    </div>

    <div class="page-header">
        <h1>错题回顾 <small>每题都有<strong>一个或多个</strong>答案，注意不是单选题。</small></h1>
    </div>
    <div class="col-md-12" style="padding-bottom: 20px">
    	<span class="error-answer">&nbsp;&nbsp;&nbsp;&nbsp;</span> 表示这个答案是错误的，但是您选择了它；
    	<span class="correct-answer">&nbsp;&nbsp;&nbsp;&nbsp;</span> 表示这个答案是正确的，并且您正确地选择了它；
    	<span class="missed-answer">&nbsp;&nbsp;&nbsp;&nbsp;</span> 表示这个答案是正确的，但是您却没有选择它。
    </div>
    <table class="table table-striped table-hover2" style="font-size: 1.2em">
    	<c:forEach var="q" items="${questions}" varStatus="s">
        <tr>
            <td class="row">
                <div class="col-md-12" style="padding-bottom: 20px">${q.title}</div>
                <div class="col-md-12 checkbox ${answerResult[s.index][0]}">
                    <label><input type="checkbox" disabled ${userAnswers[s.index][0]}> ${q.choices[0].description}</label>
                </div>
                <div class="col-md-12 checkbox ${answerResult[s.index][1]}">
                    <label><input type="checkbox" disabled ${userAnswers[s.index][1]}> ${q.choices[1].description}</label>
                </div>
                <div class="col-md-12 checkbox ${answerResult[s.index][2]}">
                    <label><input type="checkbox" disabled ${userAnswers[s.index][2]}> ${q.choices[2].description}</label>
                </div>
                <div class="col-md-12 checkbox ${answerResult[s.index][3]}">
                    <label><input type="checkbox" disabled ${userAnswers[s.index][3]}> ${q.choices[3].description}</label>
                </div>
            </td>
        </tr>
        </c:forEach>
    </table>
    
    <div class="alert alert-success" role="alert">
    	<h2>开发不易，赏个钱让我买瓶肥宅快乐水吧~(*^▽^*)</h2>
    </div>
    
    <div class="panel panel-primary">
		<div class="panel-heading"><h3>支付宝付款</h3></div>
		<div class="panel-body" style="text-align: center">
    		<img src="images/pay.jpg">
		</div>
	</div>
</div>



<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>