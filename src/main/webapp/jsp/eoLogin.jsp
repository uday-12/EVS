<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

  <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EO Login</title>

<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/homecss.css" rel="stylesheet">

<style>

.uk{
    height: 100px;
}

.conn {
	margin-left: 450px;
	margin-right: 450px;
	margin-top: 100px;
}
.navbar-nav > li{
  padding-left:30px;
  padding-right:30px;
  
}
</style>
</head>
<body>

	<!--------------------------------- Header Navigation Bar --------------------------------------------------->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark uk">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
		<a class="navbar-brand" href="#" style="padding: 4px;margin-left:100px"> <img src="images/blueLogo.png" style="height:60px;width:auto;" title="mycompanylogo"></a>
			<ul class="navbar-nav ms-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="/">Home
						
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/adminLogin">Admin</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/voterLogin">Voter</a>
				</li>
				<li class="nav-item active"><a class="nav-link active" href="/eoLogin">EO</a></li>
			</ul>
			
		</div>
	</nav>
	
	<!-------------------------------------------------------------------------------------------------------  -->
	
	<div class="conn">
		<!-- Pills content -->
		<div class="tab-content">
			<div class="tab-pane fade show active" id="pills-login"
				role="tabpanel" aria-labelledby="tab-login">
				<form action="/EOLogin" method="post">
					<!-- Email input -->
					<div class="form-outline mb-4">
						<input type="email" id="loginName" class="form-control" name="email"/> <label
							class="form-label" for="loginName">Email or username</label>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-4">
						<input type="password" id="loginPassword" class="form-control" name="password"/>
						<label class="form-label" for="loginPassword">Password</label>
					</div>

					<!-- 2 column grid layout -->
					<div class="row mb-4">
						<div class="col-md-6 d-flex justify-content-center">
							<!-- Checkbox -->
							<div class="form-check mb-3 mb-md-0">
								<input class="form-check-input" type="checkbox" value=""
									id="loginCheck" checked /> <label class="form-check-label"
									for="loginCheck"> Remember me </label>
							</div>
						</div>

						<div class="col-md-6 d-flex justify-content-center">
							<!-- Simple link -->
							<a href="#!">Forgot password?</a>
						</div>
					</div>

					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
				</form>
			</div>
		</div>
	</div>
<!--------------------------------------------------------  ---------------------------------------------------------->

<div align="center">
 <h2 style="color: red">${Invalidlogin}</h2>
</div>


</body>
</html>