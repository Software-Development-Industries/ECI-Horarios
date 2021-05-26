login = (function (){
	
	
	var port = 80;
	var url = "https://eci-horarios.herokuapp.com";
	
	var _studentLogin = async function(email, pass) {
		let isLoggued = false;
		await fetch(
            url + "/app/user/login",
            {
                method: "POST",
                body: JSON.stringify({
                    email: email,
                    pass: pass
                }),
                headers: {
      				"Content-type": "application/json; charset=UTF-8"
   				}
            }
        )
		.then((response) => response.json())
		.then((data) => {
			isLoggued=data;
		});
		
		if (isLoggued) {
			sessionStorage.setItem("currentUser", email);
			sessionStorage.setItem("loggued", true);
		}
		
		return isLoggued;
	}
	
	var _isLoggued = function() {
		let isLogguedVer = sessionStorage.getItem("loggued");
		return isLogguedVer != null && isLogguedVer === String(true); 
	}
	
	
	return {
		
		studentLogin: function() {
			
			if (_isLoggued()) {
				window.location.href = url+"/main.html";
			} else {
				_studentLogin($("#email").val(), $("#pass").val()).then((isLoggued) => {
					console.log($("#email").val(), $("#pass").val());
					if (isLoggued) {
						// Make it like this so can be optimized in the future
						sessionStorage.setItem("loggued", true);
						window.location.href = url+"/main.html";
					} else {
						alert("Usuario o contraseña no válidos");
					}
				})
			}
		},
		
		isLoggued: function() {
			if (_isLoggued()) {
				window.location.href = url+"/main.html";
			}
		}
		
	}
	
	
})();