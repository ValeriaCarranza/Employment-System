<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<title>Home</title>
</head>
<body>
	<nav class="navbar" style="background-color: #e3f2fd;">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">  Employment System
		</a>
	</div>
	</nav>
	<div class="container" mt-4>
		<h1 class="h1 text-center">Employees</h1>
		<h3>
			<a class="btn btn-info text-center" href="new">New contact</a>
		</h3>
		<div class="card" style="background-color: #e3f2fd;">
			<div class="card-header bg-info text-white text-center">Agenda</div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">No</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Address</th>
							<th scope="col">Telephone</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listContact}" var="contact" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${contact.name}</td>
								<td>${contact.email}</td>
								<td>${contact.address}</td>
								<td>${contact.phone}</td>
								<td><a href="edit?id=${contact.id}">Edit </a> <a
									href="delete?id=${contact.id}"> Delete</a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
