login = (function (){
	
	
	var url = "http://localhost:8080";
	
	var _checkLogin = async function(email, pass) {
		let isLoggued = false;
		await fetch(
            url + "/app/check-login",
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
		.then((data) => isLoggued = data);
		
		return isLoggued;
	}
	
	
	return {
		
		checkLogin: function() {
			
			if (_checkLogin($("#email").val(), $("#pass").val())) {
				window.location.href = url+"/main.html";
			} else {
				alert("Usuario o contraseña no válidos");
			}
		}
		
	}
	
	
})();