function register_user(){
		const name = document.getElementById("fname").value.trim();
		const email = document.getElementById("email").value.trim();
		const pass = document.getElementById("pwd").value.trim();
		const cpass = document.getElementById("c-pwd").value.trim();
		const male = document.getElementById("male").checked;
		const female = document.getElementById("female").checked;
		const dept = document.getElementById("dept").value;
		const mobile = document.getElementById("mobile").value.trim();
		const address = document.getElementById("add").value.trim();
			
		if(name === ""){
			alert("please enter your full name");
			return false;
		}
		if(email === ""){
			alert("please enter email id");
			return false;
		}
		if(!email.includes("@")){
			alert("please enter a valid email");
			return false;
		}
		if(pass === ""){
			alert("please enter your password");
			return false;
		}
		if (pass.length < 8) {
			alert("Password must be at least 8 characters long.");
			return false;
		}
		if(cpass === ""){
			alert("please confirm your password");
			return false;
		}
		if(cpass != pass){
			alert("your password is not matching")
			return false;
		}
		if(!male && !female){
			alert("please check your gender");
			return false;
		}
		if(dept === ""){
			alert("please select your department");
			return false;
		}
		if(mobile === "" || mobile.length != 10){
			alert("please enter a valid 10-digit mobile number");
			return false;
		}
		if(address ===""){
			alert("please enter your address");
			return false;
		}
		const userdata = {
			username : name,
			email : email,
			password : pass,
			gender: male ? "Male" : "Female",
			department : dept,
			mobile: mobile,
			address : address
		}
		localStorage.setItem(email, JSON.stringify(userdata));
		alert("Registration Successfull. You can now Login");
		return true;
}