<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Home</title>
</head>
<body>
	<div class="container">
		<h4 class="pull-right">
			<span class="glyphicon glyphicon-user"></span>
			<c:if test="${empty sessionScope.currentUser}">
				<c:out value="Guest" />
			</c:if>
			<c:if test="${not empty sessionScope.currentUser}">
				<c:out value="${sessionScope.currentUser.firstName} " />
				<c:out value="${sessionScope.currentUser.lastName}" />
			</c:if>
		</h4>
		<br />
		<div class="page-header">
			<div class="row">
				<img class="logo pull-left" src="css/images/p_logo.png" />
				<h2 class="pull-left">PhoneBook.</h2>
				<c:if test="${empty currentUser}">
					<ul class="nav nav-pills grey pull-right">
						<li role="presentation" class="active"><a href="welcome.jsp">Home</a></li>
						<li role="presentation"><a href="login.jsp">Login</a></li>
						<li role="presentation"><a href="register.jsp">Register</a></li>
					</ul>
				</c:if>
				<c:if test="${not empty currentUser}">
					<ul class="nav nav-pills grey pull-right">
						<li role="presentation" class="active"><a href="welcome.jsp">Home</a></li>
						<li role="presentation"><a href="logout">Log out</a></li>
					</ul>
				</c:if>
			</div>
		</div>

	</div>
	<div class="container">
		<div class="jumbotron">
			<div class="container text-center">
				<div class="message">
					<c:if test="${not empty sessionScope.message}">
						<h2>
							<c:out value="${message}" />
						</h2>
						<c:set var="message" scope="session" value="" />
					</c:if>
				</div>
				<h3 class="whiteMessage">Welcome to PhoneBook where stalking
					people has never been easier</h3>
				<div class="row">
					<div class="damnButtons">
						<a href="search.jsp" class="btn btn-info damnSubmitButtons">Search</a>
						<c:if test="${not empty currentUser}">
							<a href="newperson.jsp" class="btn btn-info damnSubmitButtons">Make
								Entry</a>
							<c:if test="${currentUser.role == 'admin'}">
								<a href="adminMenu.jsp" class="btn btn-info damnSubmitButtons">Admin Menu</a>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>