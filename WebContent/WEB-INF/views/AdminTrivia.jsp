<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
		integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
		crossorigin="anonymous">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
	
	<style type="text/css">
		body {
			padding: 70px 0 100px 0;
		}
	</style>
	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Quiz</title>
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-inverse navbar-fixed-top">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Trivia Challenge</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="MainTrivia">Quiz</a></li>
					<li class="active"><a href="AdminTrivia">Admin</a></li>
				</ul>
			</div>
		</nav>
	</div>
	
	<div class="container">
		<br>
		
		<div class="page-header">
			<h1>Existing Questions</h1>
		</div>
		
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Id</th>
				<th>Question</th>
				<th>Answer</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${quiz}" var="entry">
				<tr>
					<td>${entry.id}</td>
					<td>${entry.question}</td>
					<td>${entry.answer}</td>
					<td class="text-center"><a href="Delete?id=44" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		
		<form method="post">
		
			<div class="form-group">
				<label for="question">Question</label><input type="text" class="form-control" id="question" name="question" placeholder="Enter a true or false question.">
			</div>
			
			<div class="form-group">
				<label for="answer">Answer</label>
				<select class="form-control" name="answer">
					<option>True</option>
					<option>False</option>
				</select>
			</div>
			
			<button type="submit" class="btn btn-primary">Add Question</button>
			
		</form>
	</div>
</body>
</html>