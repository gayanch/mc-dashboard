<%@ page import="com.wso2telco.ids.makerchecker.util.CommonUtil" %>
<%
	String loginEndpoint = CommonUtil.constructServerUrl(request) + "/mc-dashboard/api/v1/auth/login";
%>

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css"/>
    <script type="text/javascript" src="assets/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assets/js/popper.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#">DASHBOARD / LOGIN</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <!-- <li class="nav-item active">
	        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Link</a>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Dropdown
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="#">Action</a>
	          <a class="dropdown-item" href="#">Another action</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link disabled" href="#">Disabled</a>
	      </li> -->
	    </ul>
	    <!-- <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	    </form> -->
	  </div>
	</nav>
	<p style="height: 6em;"></p>
	<div class="container">
    	<div class="row w-100 justify-content-center align-items-centers">
    		<!-- <div class="col"></div> -->
    		<div class="col-6">
    			<div class="card bg-light card-body h4">Please login</div>
    			<div class="card card-body bg-light">
    				<p>
    					<input type="text" name="username" id="username" class="form-control" placeholder="Username" value="checker2">
    				</p>
    				<p>
    					<input type="password" name="password" id="password" class="form-control" placeholder="Password" value="checker2">
    				</p>
    				<p>
    					<button class="btn btn-primary" id="btn-login">Login</button>
    				</p>
    			</div>
    		</div>
    		<!-- <div class="col"></div> -->
    	</div>
    	<br/>
    	<div class="row w-100 justify-content-center align-items-center">
    		<div class="alert alert-warning alert-dismissible fade show invisible" role="alert" id="main-alert">
			  <strong id="message-content">ssss</strong>
			  <button type="button" class="close" aria-label="Close" id="main-alert-close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
    	</div>
    </div>

    <script type="text/javascript">
    	$('#main-alert-close').on('click', function () {
  			$("#main-alert").addClass("invisible");
		});

    	$("#btn-login").on('click', e => {
    		let loginData = {"username": $("#username").val(), "password": $("#password").val()};
    		$.ajax({
    			url: "<%=loginEndpoint%>",
    			data: JSON.stringify(loginData),
    			contentType: "application/json",
    			type: "post",
    			success: function (result) {
    				console.log(result)
    				if (result) {
    					showAlert(result.message);

    					if (!result.error) {
    					    console.log("redirecting to home...");
    						window.location = "index.jsp";
    					}
    				}
    			}

    		});
    	});

    	function showAlert(message) {
    		$("#message-content").html(message);
    		$("#main-alert").removeClass("invisible");
    		setTimeout(function(){
    			$("#main-alert").addClass("invisible");
    		}, 5000);
    	}
    </script>
</body>
</html>