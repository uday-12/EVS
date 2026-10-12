<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


  <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Online EVS</title>

<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<style>
.uk{
    height: 100px;
} 
.conn{
margin : 100px;
padding : 2-px;
}

.navbar-nav > li{
  padding-left:30px;
  padding-right:30px;
  
}
.kk
{
margin:0px;
height: auto;
}
</style>

</head>
<body>


	<!--------------------------------- Header Navigation Bar --------------------------------------------------->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark uk">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		
		<a class="navbar-brand" href="#" style="padding: 4px;margin-left:100px"> <img src="images/blueLogo.png" style="height:60px;width:auto;" title="mycompanylogo"></a>
		
			<ul class="navbar-nav ms-auto mt-2">  <!-- mt-lg-0  -->
				<li class="nav-item"><a class="nav-link active" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/adminLogin">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="/voterLogin">Voter</a></li>
				<li class="nav-item"><a class="nav-link" href="/eoLogin">EO</a></li>
			</ul>
		</div>
	</nav>
	<!--------------------------------- Content Part ------------------------------------------------------------>
	<!-- <div>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			Indicators
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			Wrapper for slides
			<div class="carousel-inner">
				<div class="item active">
					<img src="/images/1.png" alt="Los Angeles" style="width: 100%;">
				</div>

				 <div class="item">
        <img src="/images/2.png" alt="Chicago" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="/images/3.png" alt="New york" style="width:100%;">
      </div>
    </div>

    Left and right controls
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
			</div>
		</div> -->
<!----------------------------------------------------------------------------------------------------------->
		<div class="conn">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="section-heading">
							<h2>About eVoting</h2>
							<p class="text-muted">Revolutioning online elections since 2003</p>
						</div>
					</div>
				</div>
				<br>
				<br>
				<br>
				<div class="row">
					<div class="col-md-6">
						<img alt="" src="/images/votecall.jpg" width="500px" height="350px">
					</div>
					<div class="col-md-6">
						<p class="text-left text-justify">
							Online Voting is a web-based voting system that will help you
							manage your elections easily and securely. This voting system can
							be used for casting votes during the elections held in colleges,
							etc. In this system the voter do not have to go to the polling
							booth to cast their vote. 
							
							<br> <br> 
							
							They can use their
							personal computer to cast their votes. There is a database which
							is maintained in which all the name of the voters with their
							complete information is stored. The System Administrator
							registers the voters by simply filling a registration form to
							register the voters. After registration, the voter is assigned a
							secret voter ID with which he/she can use to login to the system
							and cast his/her vote. If invalid/wrong details are submitted,
							then the person is not registered to vote. After the user
							successfully registers themselves, a link is sent on their
							respective E-mail IDs. 
							
							<br> <br> 
							
							The link is a key for
							the activation of the account of the user. The account is
							activated only after the user clicks on that link.
						</p>
					</div>
					<p>
							The site will
							be activated only on the day of voting. Once the user logs in,
							they will be provided with a One Time Password (OTP) which has to
							be entered by the user before casting his/her vote. The password
							will be destroyed after casting of their respective vote. A
							receipt of the vote will be sent to the user on their respective
							E-mail IDs. 
							
							<br> <br> 
							
							The advantage of online voting is
							that the voters have the choice of voting at their own free time
							and there is reduced congestion. It also minimizes on errors of
							vote counting. The individual votes are submitted in a database
							which can be queried to find out who of the aspirants for a given
							post has the highest number of votes.
					</p>
				</div>
			</div>
		</div>
<!----------------------------------------------------------- discription -------------------------------------------- -->
	<div class="container-fluid kk" style="background-color: #eee;">
		<div class="mt-3">
		<br>
		<br>
		
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="section-heading">
							<h2>About eVoting Home Page Navigation</h2>
							<p class="text-muted">"Follow the below steps to proceed with the site. it will help you to navigate properly"</p>
						</div>
					</div>
				</div>
		
		<br>
		<br>
			<div align="center">
				<div class="col-md-6"" class="mt-3">
				
					<img class="rounded-circle" width="200px" height="200px" alt="" src="/images/Admin.png">
				</div>
				<div >
					<div>
						<h4> Admin Login Page</h4>
					</div>
					<div>
						<p class="text-muted">"Admin is defaultly inserted by the programmer, Using His/Her Credientions Login to the Admin Module"</p>
					</div>
				</div>
			</div>
			
			<div align="center" class="mt-5">
				<div class="col-md-6"">
					<img class="rounded-circle" width="200px" height="200px" alt="" src="/images/EO.png">
				</div>
				<div >
					<div>
						<h4>Voter Login Page</h4>
					</div>
					<div>
						<p class="text-muted">"On clicking voter it will direct to voter login page, there u can caste your vote"</p>
					</div>
				</div>
			</div>
			<div align="center" class="mt-5">
				<div class="col-md-6"">
					<img class="rounded-circle" width="200px" height="200px" alt="" src="/images/Vote.jpg">
				</div>
				<div >
					<div>
						<h4>EO Login Page</h4>
					</div>
					<div>
						<p class="text-muted">"On clicking on EO it will direct to EO login Page, EO can perform his tasks"</p>
					</div>
				</div>
			</div>
			<br>
			<br>
		</div>
	</div>
<!--  ---------------------------------------------------------------------------------------------- -->

</body>
</html>