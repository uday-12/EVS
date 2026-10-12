<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Caste Vote</title>

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
			<ul class="navbar-nav ms-auto mt-2">
				<li class="nav-item"><a class="nav-link" href="/voterHome/${vId}">Voter Home</a></li>
				<li class="nav-item"><a class="nav-link  active" href="/casteVote">Caste Vote</a></li>
				<li class="nav-item"><a class="nav-link" href="/votersViewResults/${vId}">View Results</a></li>
				<li class="nav-item"><a class="nav-link" href="/">Log Out</a></li>
			</ul>
		</div>
	</nav>

<!---------------------------------------- Displaying Added Elections --------------------------------------------->
<div align="center"><h2  style="color: red"> ${message} </h2></div>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Candidate Name</th>
      <th scope="col">Party</th>
      <th scope="col">Party Symbol</th>
      <th scope="col">Candidate Image</th>
      <th scope="col">Constituency</th>
      <th scope="col">Cast Vote</th>
    </tr>
  </thead>
  
  <tbody>
			<core:forEach items="${candidate}" var="can">
				<core:if test="${can.electionId eq electionId}">
					<tr>
						<td>${can.candidateName}</td>
						<td>${can.candidateParty}</td>
						<td> <img src="data:image/jpeg;base64,${can.stringPartyImage}" width="50px" height="50px"/></td>
						<td> <img src="data:image/jpeg;base64,${can.stringCandidateImage}" width="50px" height="50px"/></td>
						<td>${can.candidateConstituency}</td>
						<td><button type="button" class="btn btn-success"><a class="nav-link" href="/vote/${can.candidateId}/${vId}/${electionId}" style="color: white">Vote</a></button></td>
					</tr>
				</core:if>

			</core:forEach>
		</tbody>
</table>
</body>
</html>