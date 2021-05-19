main = (function() {
	
	var port = 80;
	var url = "http://localhost:"+port;
	
	var _verifyLogin = function () {
		return sessionStorage.getItem("loggued") === String(true); 
	}
	
	var _getStudentData = async function (email) {
		var usuario = JSON.parse(sessionStorage.getItem("currentUserData"));

		if (usuario == null){
			await fetch(
				url+"/app/get-student-data/"+email,
				{
					method: "GET",
					headers: {
	      				"Content-type": "application/json; charset=UTF-8"
	   				}
				}
			)
			.then((response) => response.json())
			.then((data) => {
				usuario = data;
				return data;
			})

						
			if (usuario) {
				sessionStorage.setItem("currentUserData", JSON.stringify(usuario));
				return true;
			}
			
			return false;
		}
		
		return true;
		
	}
	
	var _displayInfo = function () {
		let display = $(".perfil-info").css("display");
		if (display == "none") {
			$(".perfil-info").css("display", "block");
		} else {
			$(".perfil-info").css("display", "none");
		}
	}
	
	return {
		
		verifyLogin: function () {
			return _verifyLogin();
		},
		
		logout: function () {
			if (_verifyLogin()) {
				sessionStorage.setItem("loggued", false);
				alert("Ha salido exitosamente de la cuenta!");
				window.location.href = "/login.html"
			}
		},
		
		getStudentData: function() {
			_getStudentData(sessionStorage.getItem("currentUser"))
			.then((response) => {
				if (response) {
					let user = JSON.parse(sessionStorage.getItem("currentUserData"));
					$(".banner").html(`<h1>BIEVENID@ ${user["nombre"].toUpperCase()}</h1>`);
					
					let userData = `<li>Nombre: ${user["nombre"]}</li>` +
									`<li>Edad: ${user["edad"]}</li>` +
									`<li>ID: ${user["identificacion"]}</li>` +
									`<li>Correo: ${user["correo"]}</li>`;
					$(".perfil-info").html("<ul>"+userData+"</ul>")
				}
			})
		},
		
		displayInfo: _displayInfo
		
	}
	
})();