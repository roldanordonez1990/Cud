<%@page import="controller.ControladorFicheros"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">      
<title>logueo</title>
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


	<%
		if (session.getAttribute("logueado") == null) {

			response.sendRedirect("index.jsp");

		} else {

			ArrayList<Persona> estudiantes = ControladorFicheros.leerFichero("D:\\estudiantes.dat");

			if (estudiantes != null) {
	%>
	<div class="container">
		<h4 style="text-align: start">Listado de estudiantesssssss</h4>
		<table class="table table-hover">
			<thead class="thead bg-success text-white">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Edad</th>
				<th>Carrera</th>
				<th>Semestre</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Persona estudiante : estudiantes) {
							out.println("<tr>");
							out.println("<td>" + estudiante.getId() + "</td>");
							out.println("<td>" + estudiante.getNombre() + "</td>");
							out.println("<td>" + estudiante.getApellido() + "</td>");
							out.println("<td>" + estudiante.getEdad() + "</td>");
							out.println("<td>" + estudiante.getCarrera() + "</td>");
							out.println("<td>" + estudiante.getSemestre() + "</td>");
							out.println("<td>" + estudiante.getEmail() + "</td>");
							out.println("</tr>");
						}
			%>
		</tbody>
	</table>
	<br>
	<form action="vistaNuevoEstudiante.jsp" method="post">

		<input type="submit" name="eliminar1" class="btn-outline-success" value="Nuevo">
	</form>
	<br>
	<form action="vistaBorrado.jsp" method="post">

		<input type="submit" name="eliminar1" class="btn-outline-danger" value="Eliminar">

	</form>
	
	<br>
	<form action="index.jsp" method="post">

		<input type="submit" name="" class="btn-outline-primary" value="Volver al inicio">

	</form>


	<%
		}
	}
	%>
</body>

</body>
</html>