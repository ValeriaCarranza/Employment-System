<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<title>Employee</title>
</head>
<body>
	<nav class="navbar" style="background-color: #40b2cd;">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> Employment System </a>
		</div>
	</nav>
	<div class="container mt-8">
		<div class="pad">
			<h3>
				<a class="btn btn-block" style="background-color: #40b2cd;"
						href="compensations?id=${employee.id_employee}">Compensations</a>
			</h3>
			
			
		</div>
		<div class="card center" style="width: 50rem; margin: auto auto;">
			<div class="card-header text-center">View/edit Employee:
				${employee.first_name}</div>
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="employee">
					<form:hidden path="id_employee" />
					<div class="form-outline mb-4">
						<form:input id="form1Example1" class="form-control"
							path="first_name" />
						<label class="form-label" for="form1Example1">First Name</label>
					</div>
					<div class="form-outline mb-4">
						<form:input id="form1Example1" class="form-control"
							path="middle_name" />
						<label class="form-label" for="form1Example1">Middle Name</label>
					</div>

					<div class="form-outline mb-4">
						<form:input id="form1Example1" class="form-control"
							path="last_name" />
						<label class="form-label" for="form1Example1">Last Name</label>
					</div>
					<div class="form-outline mb-4">
						<form:input path="birth" type="date" class="form-control" />
						<label class="form-label" for="form1Example1">Birthday</label>
					</div>

					<div class="form-outline mb-4">
						<form:input id="form1Example1" class="form-control"
							path="position" />
						<label class="form-label" for="form1Example1">Position</label>
					</div>

					<div class="row">
						<div class="col">
						<input type="submit" class="btn btn-block" style="background-color: #40b2cd;" value="Update">
						</div>
						<div class="col">
						<a class="btn btn-block" style="background-color: #40b2cd;"
						href="compensations?id=${employee.id_employee}">Compensations</a>
						</div>
					</div>
					
					

				</form:form>

			</div>

		</div>


	</div>


</body>
</html>