<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Candidates</title>

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
       <th scope="col">PartySymbol</th>
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


<!-----------------------------------------Form for Adding Elections  --------------------------------------------->
	<div class="conn">
		<form action="/addCandidates/${electionId}" method="post" enctype='multipart/form-data'>
			<!-- Name input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerName" class="form-control" name="candidateName"/> 
				<label class="form-label" for="registerName">Candidate Name</label>
			</div>

			<!-- Age input -->
			<div class="form-outline mb-4">
				<input type="number" id="registerUsername" class="form-control" name="candidateAge"/> 
				<label class="form-label" for="registerUsername">age</label>
			</div>

			<!-- Address input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerName" class="form-control" name="candidateAddress"/> 
				<label class="form-label" for="registerName">Candidate Address</label>
			</div>
			
			<!-- Party input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerName" class="form-control" name="candidateParty"/> 
				<label class="form-label" for="registerName">Candidate Party</label>
			</div>
			
			<!--CandidateConstituency input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerName" class="form-control" name="candidateConstituency"/> 
				<label class="form-label" for="registerName">Candidate Constituency</label>
			</div>
			
			<!--CandidateNumber input -->
			<div class="form-outline mb-4">
				<input type="number" id="registerName" class="form-control" name="candidateNumber"/> 
				<label class="form-label" for="registerName">Candidate Number</label>
			</div>
			<!-- Image input -->
			<div class="form-outline mb-4">
				<input type="file" class="form-control" name="file1"/> 
				<label class="form-label" for="registerImage"> Upload Candidate Image </label>
			</div>
			<!-- Image input -->
			<div class="form-outline mb-4">
				<input type="file" class="form-control" name="file2"/> 
				<label class="form-label" for="registerImage">  Upload Party Image</label>
			</div>
			
			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-3"> Create </button>

		</form>
	</div>
<!-------------------------------------------------------------------------------------------------------------------->
	
</body>
</html>