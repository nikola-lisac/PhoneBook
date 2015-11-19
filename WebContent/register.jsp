<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="files/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="files/updateStyle.css" />
<title>Register</title>
</head>
<body>
	<div class="container">
		<h4 class="pull-right">
			<span class="glyphicon glyphicon-user"></span>
			<c:out value="${sessionScope.currentUser.username}" default="Guest" />
		</h4>
		<br />
		<div class="page-header">
			<div class="row">
				<img class="logo pull-left" src="files/p_logo.png" />
				<h2 class="pull-left">PhoneBook.</h2>
				<ul class="nav nav-pills grey pull-right">
					<li role="presentation" class="active"><a href="welcome.jsp">Home</a></li>

				</ul>
			</div>
		</div>

		<div class="container">
			<div class="jumbotron responsive message">
				<c:if test="${not empty sessionScope.message}">
					<div class="errMessage">
						<p>
							<c:out value="${message}" />
						</p>
					</div>
					<c:set var="message" scope="session" value="" />
				</c:if>
				<div class="col-sm-offset-3">
					<p>Register form</p>
				</div>
				<div class="col-md-8 pull-left">
					<form class="form-horizontal" id="register" action="register"
						method="post">
						<div class="form-group">
							<label class="control-label col-sm-3">Username</label>
							<div class="col-sm-9">
								<input type="text" id="username" name="username" class="form-control">
								<label id="usernameError"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">Password</label>
							<div class="col-sm-9">
								<input id="password" type="password" name="password"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">Confirm password</label>
							<div class="col-sm-9">
								<input type="password" name="passwordConfirm"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3 ">First name:</label>
							<div class="col-sm-9">
								<input type="text" name="firstName" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">Last name</label>
							<div class="col-sm-9">
								<input type="text" name="lastName" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3">Email:</label>
							<div class="col-sm-9">
								<input type="text" name="email" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-2">
								<button type="submit" class="btn btn-default">Submit</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="javascript/jquery-2.1.4.min.js"></script>
	<script src="javascript/jquery.validate.js"></script>
	<script src="javascript/additional-methods.min.js"></script>
	<script src="javascript/validationRegister.js"></script>
	<script src="javascript/checkUsername.js"></script>
</body>
</html>