<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Election Status</title>

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
.bb {width: 150px;}
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
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="/addElection">Back</a></li>
			</ul>
		</div>
	</nav>

<!---------------------------------------- Displaying Added Elections --------------------------------------------->

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Candidate Name</th>
      <!-- <th scope="col">Date</th> -->
      <th scope="col">Party</th>
       <th scope="col">Party Symbol</th>
      <th scope="col">Candidate Image</th>
      <th scope="col">Constituency</th>
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
					</tr>
				</core:if>

			</core:forEach>
		</tbody>
</table>
<!---------------------------------------------------Start/Stop Election  ------------------------------------------------->
	<br>
	<br>
	<div class="container" align="center">
		<button type="button" class="btn btn-success bb"><a class="nav-link" href="/startElection/${electionId}" style="color: white">Start Election</a> </button>
		<button type="button" class="btn btn-danger bb"><a class="nav-link" href="/stopElection/${electionId}" style="color: white">Stop Election</a> </button>
		<core:forEach items="${election}" var="can">
			<core:if test="${can.electionId==electionId && can.stopElection == true}">
				<button type="button" class="btn btn-warning bb"><a class="nav-link" href="/approveResults/${electionId}"  style="color: white">Approve Results</a> </button>
			 </core:if>
		</core:forEach>
	</div>

	<div align="center"> <h2 style="color: green"> ${success} </h2></div>
</body>
</html>