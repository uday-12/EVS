<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Election Results</title>

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
			<ul class="navbar-nav mx-5 mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="/addElection">Back</a></li>
			</ul>
		</div>
	</nav>

<!---------------------------------------- Displaying Added Elections --------------------------------------------->
<div align="center" class="mt-5">
<div class="card" style="width: 35rem;">
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><strong> <h3>${electionName} ELECTION</h3> </strong></li>
    <li class="list-group-item"><strong><h3>WINNER IS</h3></strong></li>
    <li class="list-group-item"><strong>NAME :</strong> ${name}</li>
    <li class="list-group-item"><strong>PARTY :</strong> ${party}</li>
    <li class="list-group-item"><strong>CONSTITUENCY :</strong> ${cons}</li>
    <li class="list-group-item"><strong>VOTES :</strong> ${votes}</li>
  </ul>
  <div>
 <img src="data:image/jpeg;base64,${result1}" width="50px" height="50px"/>
 <img src="data:image/jpeg;base64,${result2}" width="50px" height="50px"/>
  </div>
</div>
</div>

<table class="table mt-5 ">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Candidate Name</th>
      <!-- <th scope="col">Date</th> -->
      <th scope="col">Party</th>
      <th scope="col">Party Symbol</th>
      <th scope="col">Candidate Image</th>
      <th scope="col">Constituency</th>
      <th scope="col">Votes</th>
    </tr>
  </thead>
  
  
  <tbody>
			<core:forEach items="${candidate}" var="can">
				<core:if test="${can.electionId eq electionId}">
					<tr>
						<td>${can.candidateName}</td>
						<%-- <td>${can.date}</td> --%>
						<td>${can.candidateParty}</td>
						<td> <img src="data:image/jpeg;base64,${can.stringPartyImage}" width="50px" height="50px"/></td>
						<td> <img src="data:image/jpeg;base64,${can.stringCandidateImage}" width="50px" height="50px"/></td>
						<td>${can.candidateConstituency}</td>
						<td>${can.vote}</td>
					</tr>
				</core:if>

			</core:forEach>
		</tbody>
</table>
</body>
</html>