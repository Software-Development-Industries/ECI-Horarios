# ***Software Development Industries***
## ***Eci-Horarios***

  - **Periodo Académico**: 2021-1
  - **Curso**: Arquitectura de Software
  - **Profesor**: Diego Alfonso Prieto Torres
  
  
- **Integrantes**:
  - Eduard Arias Rincón
  - David Coronado Gómez
  - Fabian Ramírez Pinto

### Asignación de roles:
|     Nombre    |     Rol         |
|--------------|------------- |
|Diego Alfonso Prieto	|Product Owner    |
|Eduard Arias	|Scrum Master    |
|Fabian Ramírez|Developer   |
|David Coronado |Developer   |
 

 
  ## Descripción General
 
Durante el transcurso de estudio en la Escuela Colombiana de Ingeniería hemos podido evidenciar las deficiencias que tiene la plataforma de horarios de la universidad, debido a que no facilita la vida de los estudiantes con herramientas fáciles de usar, agiles y concretas, si no que dificultan la armada de horarios de los estudiantes, hasta a un punto en que la plataforma no soporta el flujo de estudiantes y se cae. El problema es que no existen herramientas fáciles de usar y rápidas para preinscribir y inscribir horarios, dificultando así la vida de los estudiantes y tener que hacer muchas operaciones para para poder armar su horario de forma correcta, es por eso que se crea *Sistemas Horario Eci* para facilitar la vida de los estudiantes de la Escuela Colombiana De Ingeniería Julio Garavito, a un punto en que van poder armar sus horarios de la forma más fácil y rápida, teniendo un horario al gusto y de acuerdo a los requerimientos que necesite cada estudiante cada semestre.

![texto cualquiera por si no carga la imagen](https://github.com/Software-Development-Industries/ECI-Horarios/blob/master/design/FrontEnd/WireFrames/menu%20principal%20eci%20horarios.png)


 ## Descripción del Producto
 
Es un herramienta desarrollada por el grupo de desarrolladores “Software-Development-Industries” la cual se encarga de mejorar el servicio que presta el sistema de horarios, de la Escuela Colombiana de Ingeniería Julio Garavito. En la plataforma podemos encontrar varias funcionalidades que presta ya la plataforma de Sistemas Horarios, mediante Enlace Académico, con un Valor agregado de tener la posibilidad de tener varios planes de horario por el semestre que va a cursar, ya sean unos 5 o 6 planes. Logrando que cuando tenga su turno para inscribir materias pueda visualizar estos planes, permitiendo que, si alguno de estos le sirve y cuenta con la disponibilidad en todas las materias, pueda inscribir todas estas materias con un simple CLICK.  Esto con el fin de brindar un buen servicio a la comunidad de estudiantes. Entre ellas encontramos funciones como: Agregar materias a su horario que no sean académicas, si no de tipo extracurricular, y poder tener toda su programación por semestre en un mismo lugar. Consiguiendo así una mejor experiencia en la creación de horarios para los estudiantes de la Escuela Colombiana Julio Garavito.

![texto cualquiera por si no carga la imagen](https://github.com/Software-Development-Industries/ECI-Horarios/blob/master/design/FrontEnd/WireFrames/menu%20funciones%20estudiante.png)



# Despliegue en HerokuApp
>[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://eci-horarios.herokuapp.com/)

## Integración Continua con CircleCI
>[![CircleCI](https://circleci.com/gh/The-Developers-Eci/2020-2-PROYCVDS-THE_DEVELOPERS_ECI.svg?style=svg)](https://app.circleci.com/pipelines/github/Software-Development-Industries/ECI-Horarios)
>

## Calidad del Codigo con Codacy

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b62c449e43f24a86803f524a67d373ea)](https://app.codacy.com/gh/Software-Development-Industries/ECI-Horarios/dashboard)

 
## **Arquitecura y Diseño**

### Diagrama de Clase

[Presione Aqui para revisar El Diagrama De Clases]()

### Diagrama de Entidad relación
![texto cualquiera por si no carga la imagen]()

### Diagrama de despliegue
![texto cualquiera por si no carga la imagen]()

### Diagrama de casos de uso
![texto cualquiera por si no carga la imagen]()

### Diagrama de componentes
![texto cualquiera por si no carga la imagen]()

## **Manual de Usuario**

[Presione Aqui para revisar El Manual de Usuario]()


 ## **Tecnologías Utilizadas**

- **Prime Faces(FRONT)**: Fue la librería utilizada para todos los componentes relacionados con el Front-End de la plataforma. Esta fue utilizada ya que es una librería ligera y que esta encapsulada en un único JAR, el que no requiere que se haga instalación de terceros para que esta sea puesta en marcha.

- **Guice(BACK)**: Es el framework utilizado para la inyección de dependencias en Google Guice, permitiendo integrar aplicativos de Java ya hechos.

- **PostgresSQL**: Fue nuestro Principal y único servidor de base de datos usado para el proyecto, pues fue utilizado para todo el manejo de datos he información como tal, haciendo utilización de herencias , tipos de datos, funciones, restricciones y reglas de integridad útiles para el manejo de equipos y elementos del laboratorio de informática.       
# **Descripción del proceso**:

#### **Integrantes**:

- Eduard Arias.
- David Coronado.
- Fabián Ramírez Pinto.

### **Descripcion de la metodologia**

La planeación de los sprint se realizó en la primera reunión oficial de comienzo del proyecto, en donde se planteó los Sprint a trabajar y una generalidades del proyecto. Luego de eso, en la semana siguiente se comenzó a definir Sprint por Sprint de cada una de las tareas y se realizó una estimación de cuando tiempo tomaría la realización del proyecto y en cuanto tiempo se tendría si se cumpliera con todas las actividades del Sprint en las fechas establecidas.

En total fueron 3 Sprint, y todo el grupo se puso de acuerdo para la asiganacion de tareas y cuáles de ellas se deberían hacer primero. Estableciendo tareas que se deberían realizar antes y que no saldrían si no se hicieran unas antes. Se hizo la utilizacion de controlador de versiones de GitHub para verificar el progreso del proyecto y de cada uno de los estudiantes, asi como el uso de la herramienta Taiga, para el control de Sprints y de tareas.


## **Taiga**

Mediante este enlace se podra acceder a la Herramienta Taiga y conocer el proceso del Proyecto. [Taiga Software Development Industries--ECI Horarios](https://tree.taiga.io/project/fabimauri47-eci-horarios/timeline).


### ***SPRINTS y release-burndown chart***

### **SPRINT 1**

Para este Sprint se usuaron las siguientes historias de usuario propuestas, con el fin de comenzar la estructuracion del proyecto:

- Como: usuario de la universidad. Necesito: autenticarme ante el sistema satisfactoriamente. Para: poder realizar las diferentes labores que me permite el sistema, dependiendo    del rol con el que estoy registrado. Se debe usar una fuente de datos básica para la autenticación de los usuarios, donde se registre principalmente, el usuario, el rol,       estado y demás información necesaria. 
- Como: estudiante de la universidad Quiero consultar las materias disponibles para poder realizar mi horario.
- Como: administrador quiero poder agregar o quitar si es el caso, las materias que se dictaran por parte de la universidad para poder permitirle a los estudiantes consultar       estas.
- Como: estudiante quiero poder preinscribir varios planes de distintas materias para tener la idea de lo que posiblemente voy a ver este semestre.
- Como: estudiante quiero poder inscribir el plan que anteriormente grabé para seguir con mi curso académico.
- Como estudiante quiero poder retirar una materia para poder seleccionar una que mas se adecué a mi horario.

#### ***Burdown Chart***

![texto cualquiera por si no carga la imagen]()

#### ***Backlog***

![texto cualquiera por si no carga la imagen]()


### **SPRINT 2**

Para este Sprint 2 se usuaron las siguientes historias de usuario propuestas, con el fin de reorganizar el proyecto y avanzarlo lo mas que se pudiera:

- Corrección del Sprint 1
- Reporte historico de novedades
- Reporte de equipos.
- Reporte de laboratorios.
- Reporte de elementos

Se presento grandes problemas en el Sprint 1, pues tuvimos un problema de integración del sistema, específicamente en el BEAN, lo que causo muchos retrasos tanto en el Sprint 1, como en el sprint 2. Es por eso que se decidió hacer borrón y cuenta nueva, y volver a implementar desde cero, esto con el fin de que se estructurara mejor el proyecto y se mitigaran los errores. Esto sirvió y permitió solución de errores y un avance circunstancial en el proyecto.



#### ***Burdown Chart***

![texto cualquiera por si no carga la imagen]()

#### ***Backlog***

![texto cualquiera por si no carga la imagen]()


### **SPRINT 3**

Para este Sprint 3 se usuaron las siguientes historias de usuario propuestas, con el fin de comenzar a culminar el proyecto lo mas pronto posible y avanzar en lo que se podia.:

- 
- 
- 
- 
- 


Para este Sprint 3 se comenzaron a ver los rezagos de los sprint anteriores, .


#### ***Burdown Chart***

![texto cualquiera por si no carga la imagen]()

#### ***Backlog***

![texto cualquiera por si no carga la imagen]()


