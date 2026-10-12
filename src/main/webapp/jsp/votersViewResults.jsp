<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Results</title>

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
.navbar-nav > li{
  padding-left:30px;
  padding-right:30px;
  
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
		
			<a class="navbar-brand" href="#" style="padding: 4px;margin-left:100px"> <img src="images/blueLogo.png" style="height:60px;width:auto;" title="mycompanylogo"> </a>
			
			<ul class="navbar-nav ms-auto mt-2">
				<li class="nav-item"><a class="nav-link" href="/voterHome/${vId}">Voter Home</a></li>
				<li class="nav-item"><a class="nav-link  active" href="/votersViewResults/${vId}">View Results</a></li>
				<li class="nav-item"><a class="nav-link" href="/">Log Out</a></li>
			</ul>
		</div>
	</nav>
<!--------------------------------------------------------Election ----------------------------------------------->
<div align="center" class="mt-5">
	  <core:forEach items="${election}" var="can">
	  	<core:if test="${can.stopElection == true || can.startElection == true}">
	 	 	<button type="button" class="btn btn-primary bb"><a class="nav-link" href="/voterResults/${vId}/${can.electionId}" style="color: white" > ${can.electionName} </a></button>
	  	</core:if>
	  </core:forEach>
	  
	 <div align="center"><h2 style="color: red"> ${resultsNotOut} </h2> </div> 
</div>
</body>
</html>