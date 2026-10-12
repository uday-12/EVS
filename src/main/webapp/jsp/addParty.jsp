<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Party</title>

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
      <th scope="col">Party Name</th>
      <th scope="col">Party Symbol</th>
      <th scope="col">Leader</th>
    </tr>
  </thead>
  
  <tbody>
			<core:forEach items="${party}" var="can">
				 <core:if test="${can.electionId eq electionId}"> 
					<tr>
						<td>${can.partyName}</td>
						<td> <img src="data:image/jpeg;base64,${can.partySymbol}" width="50px" height="50px"/></td>
						<td>${can.partyLeader}</td>
					</tr>
				 </core:if> 

			</core:forEach>
	</tbody>
</table>


<!-----------------------------------------Form for Adding Elections  --------------------------------------------->
	<div class="conn">
		<form action="/addParty/${electionId}" method="post" enctype="multipart/form-data">
			<!-- Name input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerName" class="form-control" name="partyName"/> 
				<label class="form-label" for="registerName">Party Name</label>
			</div>

			<!-- State input -->
			<div class="form-outline mb-4">
				<input type="text" id="registerUsername" class="form-control" name="partyLeader"/> 
				<label class="form-label" for="registerUsername">Party Leader</label>
			</div>

			<!-- Image input -->
			<div class="form-outline mb-4">
				<input type="file" class="form-control" name="file"/> 
				<label class="form-label" for="registerImage">Upload Image</label>
			</div>
			
			<!-- Submit button -->
			<button type="submit" class="btn btn-primary btn-block mb-3"> Create </button>

		</form>
	</div>
<!-------------------------------------------------------------------------------------------------------------------->
	
</body>
</html>