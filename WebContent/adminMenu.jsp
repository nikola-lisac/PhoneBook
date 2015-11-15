<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="beans.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="files/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="files/style.css" />
<title>Admin menu</title>
</head>
<body>
	<div class="container">
		<h4 class="pull-right">
			<span class="glyphicon glyphicon-user"></span>
			<c:if test="${currentUser.role eq 'admin'}">
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
		<c:if test="${currentUser.role eq 'admin'}">
			<c:if test="${not empty peopleList}">
				<form action="editdelete" method="post">
					<table class="table table-striped text-center">
						<thead>
							<tr>
								<td>Check</td>
								<td>ID</td>
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

							<c:forEach var="person" items="${peopleList}">
								<tr>
									<td><input type="radio" value="${person.id}"
										name="personID"></td>
									<td><c:out value="${person.id}" /></td>
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
					<div class="container text-center">

						<input type="submit" name="action"
							class="btn btn-info damnSubmitButtons" value="edit" /> <input
							type="submit" name="action"
							class="btn btn-info damnSubmitButtons" value="delete" />

					</div>
				</form>
			</c:if>
			<c:if test="${empty peopleList}">
				<h2>No result found!</h2>
			</c:if>
		</c:if>
	</div>
</body>
</html>