preinscripcion = (function () {
	
	var port = 80;
	var url = "http://localhost:"+port;
	var modify_button = "<button>Modificar preinscripcion</button>";
	var delete_button = "<button style=\"color: red\">Elminiar preinscripción</button>";
	
	var materias = []
	
	var inscripcionHolder = {
		
		addMateria: function (sigla, grupo, creditos) {
			if (materias.find(element => element["sigla"] === sigla && element["grupo"] === grupo) == undefined){
				materias.push({
					sigla: sigla,
					grupo: grupo,
					creditos: creditos			
				});
			} else {
				return false;
			}
			
			return true;
		},
		
		quitarMateria: function (sigla, grupo) {
			var index = materias.findIndex(element => element["sigla"] === sigla && element["grupo"] === grupo); 
			materias.splice(index, 1);
		},
		
		cantidadCreditos: function() {
			var totalSum = 0;
			materias.forEach(element => {
				totalSum += element["creditos"];
			});
			return totalSum;
		},
		
		cancelar: function() {
			materias = [];
		}
		
	}
	
	var _verifyLogin = function () {
		return sessionStorage.getItem("loggued") === String(true); 
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
	
	var _getInfoMateria = async function (sigla) {
		var materia;
		
		await fetch (
			url + "/app/materia/" + sigla + "/info",
			{
				method: "GET",
				headers: {
					"Content-type": "application/json; charset=UTF-8"
				} 
			}
		)
		.then(response => response.json())
		.then(data => {
			materia = data;
			return data;
		})
		
		return materia;
	}
	
	
	return {
		
		verifyLogin: _verifyLogin,
		
		logout: function () {
			if (_verifyLogin()) {
				sessionStorage.setItem("loggued", false);
				alert("Ha salido exitosamente de la cuenta!");
				window.location.href = "/login.html"
			}
		},
		
		prepareInitialData: function () {
			_getStudentPlans(sessionStorage.getItem("currentUser"))
			.then((response) => {
				if (response) {
					let plans = JSON.parse(sessionStorage.getItem("currentUserPlans"));
					let userPlans = "Default";
					if (plans != null && plans.length > 0) {
						userPlans = "";
						plans.forEach(inscripcion => {
							if (inscripcion["horario"]["materias"].length > 0){
								let table = "<table>";
								table += "<tr>";
								table += "<th>Materia</th>";
								table += "<th>Creditos</th>";
								table += "<th>Grupo</th>";
								table += "<th>Fechas</th>";
								table += "</tr>";
								
								inscripcion["horario"]["materias"].forEach(materia => {
									let tableRow = "<tr>";
									tableRow += `<td>${materia["sigla"]}</td>`;
									tableRow += `<td>${materia["creditos"]}</td>`;
									tableRow += `<td>${materia["grupo"]["numero"]}</td>`;
									
									let fechasTable = "<td><table>";
									for (let [key, value] of Object.entries(materia["grupo"]["fechas"])) {
										fechasTable += "<tr>";
										fechasTable += `<td>${key}</td>`;
										fechasTable += `<td>${JSON.stringify(value)}</td>`;
										fechasTable += "</tr>";
									}
									fechasTable += "</table></td>";
									
									tableRow += fechasTable;
									tableRow += "</tr>";
									
									table += tableRow;
								});
								
								table += "<tr><td>"+modify_button;
								table += delete_button+"</td></tr>";
								
								userPlans += table;
							} else {
								userPlans += "<p>No tiene Materias registradas para esta preinscripción</p>"
							}
								
						});
					} else {
						userPlans = "No tiene preinscripciones registradas hasta el momento.";
					}
					
					$(".modificar").html(userPlans);
				}
			})
		},
		
		
		displayNewPlan: function() {
			let display = $(".nueva-preinscripcion").css("display");
			if (display == "none") {
				$(".nueva-preinscripcion").css("display", "block");
				$(".modificar").css("display", "none");
			}
		},
		
		cancelNewPlan: function() {
			let display = $(".nueva-preinscripcion").css("display");
			if (display != "none") {
				$(".nueva-preinscripcion").css("display", "none");
				$(".modificar").css("display", "block");
			}
			
			inscripcionHolder.cancelar();
		},
		
		nuevaMateria: function() {
			var sigla = $("#materia").val();
			var grupo = $("#grupo").val();			
			_getInfoMateria(sigla)
			.then(response => {
				inscripcionHolder.addMateria(sigla, grupo, response.creditos);
				$("#general-info").html(`Créditos: ${inscripcionHolder.cantidadCreditos()}`);
			})
		},
		
		inscribirPlan: function() {
			
		}
		
	};
	
	
})();