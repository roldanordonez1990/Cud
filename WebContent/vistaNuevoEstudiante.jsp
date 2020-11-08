<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>

<div class="card">
	<div class="card-header bg-success text-white">
		<h4 class="mb-0" style="text-align:center">Crea un nuevo estudiante</h4>
	</div>

<div class="container py-3">

<form action="/Crud/ServletNuevoEstudiante" method="post">

<div class="card-body">

Id: <input type="text" name="id">
<br>
<br>
Nombre: <input type="text" name="nombreNuevo">
<br>
<br>
Apellidos: <input type="text" name="apellidoNuevo">
<br>
<br>
Edad: <input type="text" name="edadNuevo">
<br>
<br>
Carrera: <input type="text" name="carreraNuevo">
<br>
<br>
Semestre: <input type="text" name="semestreNuevo">
<br>
<br>
Email: <input type="text" name="emailNuevo">
<br>
<br>
Password: <input type="text" name="passNuevo">
<br>
<br>
<input type="submit" name="crearNuevo" class="btn-outline-success" value="Crear">
</div>
</form>
</div>
</div>
<br>
		<form action="index.jsp" method="post">
	
			<input type="submit" name="" class="btn-outline-primary" value="Voler al inicio">
	
		</form>
		<form action="vistaAdministrador.jsp" method="post">
	
			<input type="submit" name="" class="btn-outline-dark" value="Volver atrás">
	
		</form>

</body>
</html>