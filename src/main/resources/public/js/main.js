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
				url+"/app/user/"+email + "/data",
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
	
	var _getStudentPlans = async function (email) {
		var planes = JSON.parse(sessionStorage.getItem("currentUserPlans"));
		
		if (planes == null) {
			
			await fetch (
				url + "/app/user/" + email + "/preinscripciones", 
				{
					method: "GET",
					headers: {
						"Content-type": "application/json; charset=UTF-8"
					}
				}
			)
			.then(response => response.json())
			.then(data => {
				planes = data;
				return data;
			})
			
			if (planes) {
				sessionStorage.setItem("currentUserPlans", JSON.stringify(planes));
			}
		}
		
		return planes;
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
					$(".perfil-info").html("<ul>"+userData+"</ul>");
				}
			})
		},
		
		displayInfo: _displayInfo,
		
		getStudentPlans: function () {
			_getStudentPlans(sessionStorage.getItem("currentUser"))
			.then((response) => {
				if (response) {
					let plans = JSON.parse(sessionStorage.getItem("currentUserPlans"));
					let userPlans = "Default";
					if (plans != null && plans.length > 0) {
						userPlans = "";
						plans.forEach(inscripcion => {
							userPlans += JSON.stringify(inscripcion);
							userPlans += "<br>";
						});
					} else {
						userPlans = "No tiene preinscripciones registradas hasta el momento.";
					}
					
					let registroVista = $("#registro-view");
					registroVista.prepend("<p>"+userPlans+"</p>");
					registroVista[0].showModal();
				}
				
			})
			$("#close-registro-view").on('click', function () {
				$("#registro-view p").remove();
				$("#registro-view")[0].close();
			});
		}
		
	}
	
})();