<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />

	<title>Quiz</title>
</head>

<body>
	<div class = "container">
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
					<li class="active"><a href="MainTrivia">Quiz</a></li>
					<li><a href="AdminTrivia">Admin</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h1>${questions.question}</h1>
			<form action="MainTrivia" method="post">
				<input type="hidden" name="id" value="${question.id}" />
				<p class="text-center">
					<input class="btn btn-primary btn-lg" id="${question.id}" type="submit" name="answer" value="True" />
					<input class="btn btn-primary btn-lg" type="submit" name="answer" value="False" />
				</p>
			</form>
		</div>
	</div>

</body>
</html>