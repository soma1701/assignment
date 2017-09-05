
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1 charset =UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="WEB-INF/css/reg.css" />

<style>
		  .submit,.facebook,.google{height:45px;color:white;width:80%}
		  #facebbok{background-color:blue}
		  #google{background-color:black}
		  .submit{background-color:rgba(79, 222, 222, 0.72)}
		  .container{ max-width:770px}
		  .email,.password{height:45px;width:80%}
		  .right{border-left:1px solid}
		  /* {height:45px;color:white;width:80%}
		 {height:45px;color:white;width:80%}
		 {height:45px;width:80%;padding:5px}
		  {height:45px;width:80%;padding:5px} */
		</style>
<title>Signin page</title>
<script type="text/javascript">
	function validateEmail() {
		var email = document.getElementById("email").value;
		var pass = document.getElementById("password").value;
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

		var isValid = false;
		isValid = re.test(email);
		if (!isValid) {
			alert("email is not valid");
		}

		if (pass == "") {
			alert("password cann't be empty");
			isValid = false;
		}

		return isValid;
		/* return re.test(email); */

	}
</script>
</head>
<body>
	<div class="container">
		<h2>sign in</h2>
		<hr>
		<form action="signin" name="signin" method="get" onsubmit="return validateEmail()">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<h2>use other account</h2>
						<p>You can also sign in using facebook account and google
							account</p>
						<br>
						<button id="facebook" class="btn facebook" style="background-color: blue">
							login using facebook</button>
						<br> <br>
						<button id="google" type="button" class="btn google"
							style="background-color: black">login using google</button>
					</div>
				</div>
				<div class="col-sm-6 right">
					<div class="form-group">
						<h3>Using your account</h3>
						<input id="email" class="email" type="text" name="email" placeholder="Enter ur mail"><br>
						<input id="password" class="password" type="password" name="password" placeholder="Enter ur password"><br>
						<input type="hidden" value="LOGIN" name="ACTION_MODE"> <br>
						<!-- <button id="sign1" class="btn" style="background-color: rgba(79, 222, 222, 0.72)">
							<b>Sign In</b>
						</button> -->
						<input type="submit" value="Submit" class="submit">
						<br> <br>
						<a href="">Forgot ur password?</a>
					</div>
				</div>
				</div>
		</form>
	</div>
</body>
</html>