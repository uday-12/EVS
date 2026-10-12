<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter Register</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/homecss.css" rel="stylesheet" />
<style>
.uk{
	 height: 100px;
}
.conn{
margin-left:450px;
margin-right:450px;
margin-top:100px;
}
</style>
</head>
<body>
<!--------------------------------------------------------  Header Navigation Bar -------------------------------------------------------------- -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark uk">`
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="/">Back
				</a>
				</li>
			</ul>
		</div>
	</nav>

<!--------------------------------------------------------- Register Form  ---------------------------------------------------------->
		<div class="conn">
				<form action="/voterRegister" method="post">
					<!-- Name input -->
					<div class="form-outline mb-4">
						<input type="text" id="registerName" class="form-control" name="voterName" /> 
						<labe class="form-label" for="registerName">Name</label>
					</div>

					<!-- DoB input -->
					<div class="form-outline mb-4">
						<input type="date" id="registerUsername" class="form-control" name="voterDOB" />
						<label class="form-label" for="registerUsername">DOB</label>
					</div>
					<!--Gender  -->
					<div class="form-outline mb-4">
						<input type="text" id="registerName" class="form-control" name="voterGender" /> <label
							class="form-label" for="registerName">Gender</label>
					</div>
					<!--Address  -->
					<div class="form-outline mb-4">
						<input type="text" id="registerName" class="form-control" name="voterAddress"/> <label
							class="form-label" for="registerName">Address</label>
					</div>
					<!--number  -->
					<div class="form-outline mb-4">
						<input type="number" id="registerName" class="form-control" name="voterNumber"/> <label
							class="form-label" for="registerName">Mobile Number</label>
					</div>
					<!--District  -->
					<div class="form-outline mb-4">
						<input type="text" id="registerName" class="form-control" name="voterDistrict"/> <label
							class="form-label" for="registerName">District</label>
					</div>
					<!-- Email input -->
					<div class="form-outline mb-4">
						<input type="email" id="registerEmail" class="form-control" name="voterEmail"/> <label
							class="form-label" for="registerEmail">Email</label>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="registerPassword" class="form-control" name="voterPassword"/>
						<label class="form-label" for="registerPassword">Password</label>
					</div>

					<!-- Repeat Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="registerRepeatPassword" class="form-control" name="voterRepeatPassword"/> 
						<label class="form-label" for="registerRepeatPassword">Repeat password</label>
					</div>

					<!-- Checkbox -->
					<div class="form-check d-flex justify-content-left mb-4">
						<input class="form-check-input me-2" type="checkbox" value="" id="registerCheck" checked aria-describedby="registerCheckHelpText" /> 
						<label class="form-check-label" for="registerCheck"> I have read and agree to the terms </label>
					</div>

					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-3">Submit</button>
				</form>
			</div>
			
			<div align="center"><p style="color: red">${password}</p></div>
</body>
</html>