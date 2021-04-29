login = (function (){
	
	
	var url = "http://localhost:8080";
	
	var _checkLogin = async function(email, pass) {
		let isLoggued = false;
		const data = await fetch(
            url + "/app/check-login",
            {
                method: 'POST',
                body: JSON.stringify({
                    "email": email,
                    "pass": pass
                }),
                headers: {
                    "Content-type": "application/json"
                }
            }
        )
		.then((response) => {
			return response.json();
		})
		.then((data) => {
			isLoggued = data;
			return data;
		});
		
		return isLoggued;
	}
	
	
	return {
		
		checkLogin: function() {
			if (_checkLogin($("#email").val(), $("#pass").val())) {
				window.location.href = "http://www.w3schools.com";
			} else {
				alert("Usuario o contraseña no válidos");
			}
		}
		
	}
	
	
})();