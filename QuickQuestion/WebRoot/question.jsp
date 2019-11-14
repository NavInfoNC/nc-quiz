<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>金辉程序员考试系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style type="text/css">
        .table-hover2 td:hover
        {
            background-color: #fff9d8;
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
        <h1>金辉程序员考试系统 beta 1.1</h1>
    </div>

    <div class="page-header">
        <h1>不定项选择题 <small>每题都有<strong>一个或多个</strong>答案，注意不是单选题。</small></h1>
    </div>
    <form action="answer.html" method="POST">
        <table class="table table-striped table-hover2" style="font-size: 1.2em">
        	<c:forEach var="q" items="${questions}" varStatus="s">
        	<tr>
        		<td class="row">
        			<div class="col-md-12" style="padding-bottom: 20px">${q.title}</div>
                    <div class="col-md-12 checkbox">
                        <label><input type="checkbox" name="Q${s.index + 1}" value="A"> ${q.choices[0].description}</label>
                    </div>
                    <div class="col-md-12 checkbox">
                        <label><input type="checkbox" name="Q${s.index + 1}" value="B"> ${q.choices[1].description}</label>
                    </div>
                    <div class="col-md-12 checkbox">
                        <label><input type="checkbox" name="Q${s.index + 1}" value="C"> ${q.choices[2].description}</label>
                    </div>
                    <div class="col-md-12 checkbox">
                        <label><input type="checkbox" name="Q${s.index + 1}" value="D"> ${q.choices[3].description}</label>
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
    </form>
</div>

<br>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>