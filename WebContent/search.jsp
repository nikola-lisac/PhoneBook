<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="files/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="files/style.css" />
<title>Phonebook search</title>
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
				<img class="logo pull-left" src="files/p_logo.png" />
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
			<div class="row">
				<div class="container pull-left col-md-6 whiteMessage">
					<p>Search</p>
					<form action="search" method="get">
						<div class="form-group">
							<br /> <input id="searchBox" class="blackMessage"
								placeholder="Enter first name, last name or city" type="text"
								name="keyword" />
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-default" value="Search" />
						</div>

					</form>
				</div>
				<div class="pull-right col-md-4">
					<img class="img-responsive" src="files/phonebook.png">
				</div>
			</div>
		</div>
	</div>
</body>
</html>