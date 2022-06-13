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
<title>Edit Compensation</title>
</head>
<body>
	<nav class="navbar" style="background-color: #40b2cd;">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> Employment System </a>
		</div>
	</nav>
	<div class="container" mt-8>
		<div class="card center" style="width: 50rem; margin: auto auto;">
			<div class="card-header text-center">Edit Compensation </div>
			<div class="card-body">

				<form:form action="updated" method="post"
					modelAttribute="compensation">
					<form:hidden path="id_compensation" />
					<div class="form-outline mb-4">
						<form:select id="inputState" path="type_com" class="form-control">
							<form:option value="null">Choose...</form:option>
							<form:option value="Salary">Salary</form:option>
							<form:option value="Bonus">Bonus</form:option>
							<form:option value="Commission">Commission</form:option>
							<form:option value="Allowance">Allowance</form:option>
							<form:option value="Adjustment">Adjustment</form:option>
						</form:select>
						<label class="form-label" for="form1Example1">Type</label>
					</div>
					<div class="form-outline mb-4">
						<form:input id="form1Example1" type="numeric" class="form-control"
							path="amount" />
						<label class="form-label" for="form1Example1">Amount</label>
					</div>

					<div class="form-outline mb-4">
						<form:input id="form1Example1" class="form-control"
							path="description_com" />
						<label class="form-label" for="form1Example1">Description</label>
					</div>

					<div class="form-outline mb-4">
						<form:input id="form1Example1" type="date" class="form-control"
							path="date_com" />
						<label class="form-label" for="form1Example1">Date</label>
					</div>
					<form:hidden path="id_employee" />

					<input type="submit" class="btn btn-primary btn-block "
						value="save">
				</form:form>
			</div>

		</div>
	</div>
</body>
</html>