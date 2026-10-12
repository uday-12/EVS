<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding EO</title>
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
				<li class="nav-item">
					<a class="nav-link" href="/addElection">Back</a>
				</li>
			</ul>
		</div>
	</nav>

<!--------------------------------------------------------- Register Form  ---------------------------------------------------------->
		<div class="conn">
				<form action="/addingEO/${electionId}" method="post">
					<!-- Name input -->
					<div class="form-outline mb-4">
						<input type="text" id="registerName" class="form-control" name="eoName" /> 
						<labe class="form-label" for="registerName">Name</label>
					</div>
					<!-- Email input -->
					<div class="form-outline mb-4">
						<input type="email" id="registerEmail" class="form-control" name="eoEmail"/> <label
							class="form-label" for="registerEmail">Email</label>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="registerPassword" class="form-control" name="eoPassword"/>
						<label class="form-label" for="registerPassword">Password</label>
					</div>
					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-3">Sign in</button>
				</form>
			</div>
			
			<div align="center"><h2 style="color: green">${success}</h2></div>
</body>
</html>