<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
</head>
<body>
	
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f06292">
			<div>
				<a href="#" class="navbar-brand text-center">Gestión de Ciclistas</a>
			</div>
			
			<ul>
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link"></a></li>
			</ul>
		</nav>
		
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Ciclistas</h3>
			<hr>
			<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar nuevo ciclista</a>
			</div>
			<br>
			
			<table class="table table-bordered">
				<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Pais</th>
					<th>Equipo</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var= "ciclista" items="${listCiclista}">
					<tr>
						<td>
						 	<c:out value="${ciclista.id}"/>
						</td>
						<td>
						 	<c:out value="${ciclista.name}"/>
						</td>
						<td>
						 	<c:out value="${ciclista.email}"/>
						</td>
						<td>
						 	<c:out value="${ciclista.country}"/>
						</td>
						<td>
						 	<c:out value="${ciclista.team}"/>
						</td>
						<td><a href="edit?id=<c:out value='${ciclista.id}'/>">Editar </a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${ciclista.id}'/>">Eliminar</a>  </td>
					</tr>
					
					
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>

</body>
</html>