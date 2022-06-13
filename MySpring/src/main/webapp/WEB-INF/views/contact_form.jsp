<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>New Contact</title>
</head>
<body>

	<div class="container" mt-8>
		<h2>New/Edit contact</h2>
	
		<form:form action="save" method="post" modelAttribute="contact">	
		<form:hidden path="id"/>
			<div class="form-outline mb-4">
				<form:input  id="form1Example1" class="form-control" path="name" /> <label
					class="form-label" for="form1Example1">Name</label>
			</div>
			<div class="form-outline mb-4">
				<form:input type="email" id="form1Example1" class="form-control" path="email" /> <label
					class="form-label" for="form1Example1">Email address</label>
			</div>
			
			<div class="form-outline mb-4">
				<form:input  id="form1Example1" class="form-control" path="address" /> <label
					class="form-label" for="form1Example1">Address</label>
			</div>
			<div class="form-outline mb-4">
				<form:input  id="form1Example1" class="form-control" path="phone" /> <label
					class="form-label" for="form1Example1">Telephone</label>
			</div>
			
			<input type="submit" class="btn btn-primary btn-block " value="save"> 
		</form:form>
	</div>
</body>
</html>