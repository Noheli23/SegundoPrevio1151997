<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Ciclista</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f06292">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Gestión de Ciclistas</a>
			</div>
			
			<ul>
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Ciclistas</a></li>
			</ul>
		</nav>
	</header>
		<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${ciclista != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${ciclista == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
				<h2>
				<c:if test="${ciclista != null}">Editar ciclista</c:if>
				<c:if test="${ciclista == null}">Agregar nuevo ciclista</c:if>
				</h2>
				</caption>
				
				<c:if test="${ciclista != null}">
				 <input type="hidden" name="id" value="<c:out value='${ciclista.id}'/>"/>
				</c:if>
				
				<fieldset class="form-group">
					<label>Nombre </label> <input type="text" value="<c:out value='${ciclista.name}'/>" class="form-control" name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email </label> <input type="text" value="<c:out value='${ciclista.email}'/>" class="form-control" name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Fecha de nacimiento</label> <input type="text" value="<c:out value='${ciclista.bithdate}'/>" class="form-control" name="birthdate" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>País</label> <input type="text" value="<c:out value='${ciclista.country}'/>" class="form-control" name="country" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Equipo</label> <input type="text" value="<c:out value='${ciclista.team}'/>" class="form-control" name="team" required="required">
				</fieldset>
				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	
	</div>
</body>
</html>