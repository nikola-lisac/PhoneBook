<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="files/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="files/styleLogin.css" />
<title>Login</title>
</head>
<div class="container">
	<h4 class="pull-right">
		<span class="glyphicon glyphicon-user"></span>
		<c:if test="${empty sessionScope.currentUser}">
			<c:out value="Guest" />
		</c:if>
	</h4>
	<br />
	<div class="page-header">
		<div class="row">
			<img class="logo pull-left" src="files/p_logo.png" />
			<h2 class="pull-left">PhoneBook.</h2>
			<ul class="nav nav-pills grey pull-right">
				<li role="presentation" class="active"><a href="welcome.jsp">Home</a></li>
				<li role="presentation"><a href="search.jsp">Search</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<div class="jumbotron message">
		<c:if test="${not empty sessionScope.message}">
			<div class="errMessage text-center">
				<p>
					<c:out value="${message}" />
				</p>
			</div>
			<c:set var="message" scope="session" value="" />
		</c:if>
		<div class="col-sm-offset-2">
			<p>Login:</p>
		</div>
		<div class="row">
			<div class="col-md-8 pull-left">

				<form class="form-horizontal" id="login" action="loginServlet"
					method="post">
					<div class="form-group">
						<label class="control-label col-sm-3">Username:</label> <input
							class="blackMessage" type="text" name="username" />
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Password:</label> <input
							class="blackMessage" type="password" name="password" />
					</div>
					<br />
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-3">
							<button type="submit" class="btn btn-default">Log in</button>
						</div>
					</div>
				</form>

			</div>
			<div class="pull-right col-md-4">
				<img class="img-responsive daaamnImg" src="files/phonebook.png">
			</div>
		</div>
	</div>
</div>
</body>
</html>