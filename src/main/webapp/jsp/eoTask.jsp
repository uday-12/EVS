<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EO Task</title>

<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/homecss.css" rel="stylesheet">

<style>
.uk {
	height: 100px;
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
			<ul class="navbar-nav ms-auto mt-2">
				<li class="nav-item"><a class="nav-link" href="/eoHome">EO Home</a></li>
				<li class="nav-item"><a class="nav-link active" href="/eoTask">EO Task</a></li>
				<li class="nav-item"><a class="nav-link" href="/">Log Out</a></li>
			</ul>
		</div>
	</nav>

<!---------------------------------------- Displaying Voter Request --------------------------------------------->

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Voter Id</th>
      <!-- <th scope="col">Date</th> -->
      <th scope="col">Voter Name</th>
      <th scope="col">District</th>
      <th scope="col">Approve</th>
      <th scope="col">Disapprove</th>
    </tr>
  </thead>
  
  <tbody>
			<core:forEach items="${voter}" var="can">
				<core:if test="${can.voterEORequest == true && can.eoResponceVoter == false}">
					<tr>
						<td>${can.vId}</td>
						<%-- <td>${can.date}</td> --%>
						<td>${can.voterName}</td>
						<td>${can.voterDistrict}</td>
						<td><a href="/approve/${can.vId}">Approve</a></td>
						<td><a href="/disapprove/${can.vId}">Disapprove</a></td>
					</tr>
				</core:if>

			</core:forEach>
		</tbody>
</table>



</body>
</html>