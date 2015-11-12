<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="stuff.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="files/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="files/style.css" />
<title>Search results</title>
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
		<c:if test="${not empty listOfPeople}">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>First name</td>
						<td>Last name</td>
						<td>Gender</td>
						<td>Address</td>
						<td>City</td>
						<td>Phone</td>
						<td>Email</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="person" items="${listOfPeople}">
						<tr>
							<td><c:out value="${person.firstName}" /></td>
							<td><c:out value="${person.lastName}" /></td>
							<td><c:out value="${person.gender}" /></td>
							<td><c:out value="${person.address}" /></td>
							<td><c:out value="${person.city}" /></td>
							<td><c:out value="${person.phone}" /></td>
							<td><c:out value="${person.email}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty listOfPeople}">
			<h2>No result found!</h2>
		</c:if>
	</div>
</body>
</html>