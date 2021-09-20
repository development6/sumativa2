<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
</head>
<body>
	<div>
	<h1>Productos</h1>

		<br>
		<h1>Lista de productos</h1>
		
				
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Tipo</th>
					<th>Acciones</th>
				</tr>
			</thead>

			<tbody>
				<tr>
				<form action="/resumen/ingresar" method="post"> <!-- para no pasar parametro por parametro -->
					<c:forEach var="producto" items="${listaProductos}">
						<tr>
							<td><c:out value=""></c:out></td>
							<td><c:out value="${producto.nombre}"></c:out></td>
							<td><c:out value="${producto.precio}"></c:out></td>
							<td><c:out value="${producto.tipo}"></c:out></td>
							<td>
								<input type="checkbox" value="${producto.id}"/>
                            </td>

						</tr>
					</c:forEach>
				<input type ="submit" value="Guardar">
				</form>
				</tr>
			</tbody>

		</table>

	</div>
</body>
</html>
