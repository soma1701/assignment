function validate(){
	var userName = document.getElementById("userName").value;
//	var male = document.getElemetById("male").value;
//	var female = document.getElementById("female").value;
	var mobileNumber = document.getElementById("mobileNumber").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	var regex =/^ [a-z0-9.]+@[a-z]+.[a-z]{2,4}^$/;
	var isValid = regex.test(email);
	if(userName==""||userName==null){
		alert("userName must be contains some words")
		return false;
	}
	else if(document.getElementById("male").checked){
		var male = document.getElementById("male").value;
		var female = document.getElementById("female").value;
			
	}
	else if(!(isValid)){
		alert("email is not valid");
		return false;
	}
	else if(!(password==confirmPassword)){
		alert("please reconfirm your password");
		return false;
	}
	else if(mobileNumber.length<10){
		alert("your number should contain 10 digit only");
		return false;
	}
	return true;
}
	
	
