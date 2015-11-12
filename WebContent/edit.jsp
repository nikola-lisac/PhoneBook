<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="files/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="files/updateStyle.css" />
<title>Edit person</title>
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
				<ul class="nav nav-pills grey pull-right">
					<li role="presentation" class="active"><a href="welcome.jsp">Home</a></li>
					<li role="presentation"><a href="logout">LogOut</a></li>
				</ul>
			</div>
		</div>

	</div>
	<div class="container">
		<div class="jumbotron responsive message">
			<div class="col-sm-offset-3">
				<p>Edit the person</p>
			</div>
			<c:if test="${sessionScope.currentUser.role eq 'admin'}"></c:if>
			<div class="col-md-8 pull-left">
				<form class="form-horizontal" id="editPerson" action="editPerson"
					method="post">
					<div class="form-group">
						<label class="control-label col-sm-3 ">First name:</label>
						<div class="col-sm-9">
							<input type="text" value="${personToEdit.firstName }"
								placeholder="${personToEdit.firstName }" name="firstName"
								class="form-control"> <input type="hidden"
								value="${personToEdit.id }" name="personID" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Last name</label>
						<div class="col-sm-9">
							<input type="text" value="${personToEdit.lastName }"
								placeholder="${personToEdit.lastName }" name="lastName"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Address:</label>
						<div class="col-sm-9">
							<input type="text" value="${personToEdit.address }"
								placeholder="${personToEdit.address }" name="address"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">City:</label>
						<div class="col-sm-9">
							<input type="text" value="${personToEdit.city }"
								placeholder="${personToEdit.city }" name="city"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Gender:</label>
						<div class="col-sm-9">
							<div>
								<c:if test="${personToEdit.gender eq 'M' }">
									<label class="radio-inline "> <input type="radio"
										name="gender" checked="checked" value="M">Male
									</label>
									<label class="radio-inline "> <input type="radio"
										name="gender" value="F">Female
									</label>
								</c:if>
								<c:if test="${personToEdit.gender eq 'F' }">
									<label class="radio-inline "> <input type="radio"
										name="gender" value="M">Male
									</label>
									<label class="radio-inline "> <input type="radio"
										name="gender" checked="checked" value="F">Female
									</label>
								</c:if>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Email:</label>
						<div class="col-sm-9">
							<input type="text" value="${personToEdit.email }"
								placeholder="${personToEdit.email }" name="email"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Phone number:</label>
						<div class="col-sm-9">
							<input type="text" value="${personToEdit.phone }"
								placeholder="${personToEdit.phone }" name="phone"
								class="form-control">
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


	<script src="javascript/jquery-2.1.4.min.js"></script>
	<script src="javascript/jquery.validate.js"></script>
	<script src="javascript/additional-methods.min.js"></script>
	<script src="javascript/validationEdit.js"></script>
</body>
</html>