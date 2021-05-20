<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f06292">
			<div>
				<a href="#" class="navbar-brand">Gestión de Ciclistas</a>
			</div>
			
			<ul>
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link"> Ciclistas</a></li>
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
					<th>Email</th>
					<th>País</th>
					<th>Acciones</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var= "usuario" items="${listUsuarios}">
					<tr>
						<td>
						 	<c:out value="${usuario.id}"/>
						</td>
						<td>
						 	<c:out value="${usuario.nombre}"/>
						</td>
						<td>
						 	<c:out value="${usuario.email}"/>
						</td>
						<td>
						 	<c:out value="${usuario.pais}"/>
						</td>
						<td><a href="edit?id=<c:out value='${usuario.id}'/>">Editar </a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${usuario.id}'/>">Eliminar</a>  </td>
					</tr>
					
					
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>

</body>
</html>