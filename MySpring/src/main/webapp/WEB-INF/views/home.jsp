<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Employment System</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #566787;
	background: #f7f5f2;
	font-family: 'Roboto', sans-serif;
}

.table-responsive {
	margin: 30px 0;
}

.table-wrapper {
	min-width: 1000px;
	background: #fff;
	padding: 20px 25px;
	border-radius: 3px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.pad{
	padding-top:25px;
}

.table-title {
	color: #fff;
	background: #40b2cd;
	padding: 16px 25px;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.search-box {
	position: relative;
	float: right;
}

.search-box .input-group {
	min-width: 300px;
	position: absolute;
	right: 0;
}

.search-box .input-group-addon, .search-box input {
	border-color: #ddd;
	border-radius: 0;
}

.search-box input {
	height: 34px;
	padding-right: 35px;
	background: #f4fcfd;
	border: none;
	border-radius: 2px !important;
}

.search-box input:focus {
	background: #fff;
}

.search-box input::placeholder {
	font-style: italic;
}

.search-box .input-group-addon {
	min-width: 35px;
	border: none;
	background: transparent;
	position: absolute;
	right: 0;
	z-index: 9;
	padding: 6px 0;
}

.search-box i {
	color: #a0a5b1;
	font-size: 19px;
	position: relative;
	top: 2px;
}

table.table {
	table-layout: fixed;
	margin-top: 15px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table th:first-child {
	width: 60px;
}

table.table th:last-child {
	width: 120px;
}

table.table td a {
	color: #a0a5b1;
	display: inline-block;
	margin: 0 5px;
}

table.table td a.view {
	color: #03A9F4;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
}

table.table td i {
	font-size: 19px;
}
</style>
<script>
	$(document).ready(function() {
		// Activate tooltips
		$('[data-toggle="tooltip"]').tooltip();

		// Filter table rows based on searched term
		$("#search").on("keyup", function() {
			var term= $(this).val().toLowerCase();
			$("table tbody tr").each(function() {
				$row = $(this);
				var name = $row.find("td:nth-child(2)").text().toLowerCase();
				console.log(name);
				if (name.search(term) < 0) {
					$row.hide();
				} else {
					$row.show();
				}
			});
		});
	});
</script>
</head>
<body>
	<nav class="navbar" style="background-color: #40b2cd;">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> Employment System </a>
	</div>
	</nav>
	
	<div class="container-lg">
		
		<c:if test="${success != null }">
			<div class="alert alert-success">${success}</div>
		</c:if>
		
		<c:if test="${editSuccess != null }">
			<div class="alert alert-success">${editSuccess}</div>
		</c:if>
		
		<c:if test="${failed != null }">
			<div class="alert alert-danger">${failed}</div>
		</c:if>
		
		<div class="pad">
		<h3>
			<a class="btn btn-info text-center" href="new">New Employee</a>
		</h3>
		</div>
		
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-6">
							<h2>
								Employees <b>Details</b>
							</h2>
						</div>
						<div class="col-sm-6">
							<div class="search-box">
								<div class="input-group">
									<input type="text" id="search" class="form-control"
										placeholder="Search by Name"> <span
										class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th style="width: 22%;">First Name</th>
							<th style="width: 22%;">Middle Name</th>
							<th>Last name</th>
							<th>Birthday</th>
							<th>Positions</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="li" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${li.first_name}</td>
								<td>${li.middle_name}</td>
								<td>${li.last_name}</td>
								<td>${li.birth}</td>
								<td>${li.position}</td>
								<td><a href="edit?id=${li.id_employee}" class="edit"
									title="Edit" data-toggle="tooltip"><i
										class="material-icons">&#xE254;</i></a> <a
									href="delete?id=${li.id_employee}" class="delete" title="Delete"
									data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>