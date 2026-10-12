<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Elections</title>

<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/homecss.css" rel="stylesheet">

<style>
.uk {
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
<!---------------------------------------- Navigation Bar -------------------------------------------------------->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark uk">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		<a class="navbar-brand" href="#" style="padding: 4px;margin-left:100px"> <img src="images/blueLogo.png" style="height:60px;width:auto;" title="mycompanylogo"></a>
			<ul class="navbar-nav ms-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="/adminHome">Admin Home</a></li>
			</ul>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link active" href="/addElection">Add Election</a></li>
			</ul>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="/viewResults">View Results</a></li>
			</ul>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="/">Log Out</a></li>
			</ul>
		</div>
	</nav>
<!---------------------------------------- Displaying Added Elections --------------------------------------------->

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Election Name</th>
      <!-- <th scope="col">Date</th> -->
      <th scope="col">State</th>
      <th scope="col">Add Party</th>
      <th scope="col">Add Candidates</th>
      <th scope="col">Add EO</th>
      <th scope="col">View Status</th>
    </tr>
  </thead>
  
  <tbody>
    <core:forEach items="${elections}" var="can">
			<tr>
				<td>${can.electionName}</td>
				<%-- <td>${can.date}</td> --%>
				<td>${can.state}</td>
				<td><button type="button" class="btn btn-success"><a class="nav-link" href="/addParty/${can.electionId}" style="color: white">Add </a></button></td>
				<td><button type="button" class="btn btn-success"><a class="nav-link" href="/addCandidates/${can.electionId}" style="color: white">Add </a></button></td>
				<td><button type="button" class="btn btn-success"><a class="nav-link" href="/addEO/${can.electionId}" style="color: white">Add</a></button></td>
				<td><button type="button" class="btn btn-warning"><a class="nav-link" href="/viewStatus/${can.electionId}" style="color: white">View</a></button></td>
			</tr>
	</core:forEach>
  </tbody>
</table>


<!-----------------------------------------Form for Adding Elections  --------------------------------------------->
	<div class="conn">
		<form action="/addElection" method="post">
			<!-- Name input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerName" class="form-control" name="electionName"/> 
				<label class="form-label" for="registerName">Election Name</label>
			</div>

			<!-- State input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerUsername" class="form-control" name="state"/> 
				<label class="form-label" for="registerUsername">State</label>
			</div>

		<!-- 	<!-- Date input -->
			<!-- <div class="form-outline mb-4">
				<input type="date" class="form-control" name="date"/> 
				<label class="form-label" for="registerEmail">Date</label>
			</div> -->

			<!-- Constituency input -->
			<div class="form-outline mb-4">
				<input type="text" class="form-control" name="constituency"/> 
				<label class="form-label" for="registerPassword">Constituency</label>
			</div>
			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-3"> Create </button>

		</form>
	</div>
<!-------------------------------------------------------------------------------------------------------------------->
	
</body>
</html>