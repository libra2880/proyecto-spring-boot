<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<%@include file="/template/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"  href="${path}/css/bootstrap.min.css">

		<script  type="text/javascript"  src="${path}/js/jquery.min.js"></script>
			<script    type="text/javascript"  src="${path}/js/bootstrap.min.js"></script>			
			<script   type="text/javascript" src="${path}/js/popper.min.js"></script>
			<script   type="text/javascript" src="${path}/js/main.js"></script>  
<title>Lista Usuarios</title>
</head>
<body>
<br>
<br>
<div class="container">
		<br>
		 <button  class="btn btn-primary nBtn2" >Nuevo</button>
 		  <br>
 		  <br>

		<div class="card">
 	<div class="card-block">
		<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nombre Usuario</th>
						<th>CLave</th>
						<th>Rol</th>		
						<th>Actualizar</th>
						<th>Eliminar</th>						
					</tr>
				</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
			
			
			
			<tr>
					<td>${usuario.usuarioId}</td>
					<td>${usuario.usuarioNombre}</td>
					<td>${usuario.clave}</td>
					<td>${usuario.rol.nombre}</td>
					<td><a href="${path}/usuario/actualizar/${usuario.id}" class="btn btn-primary eBtn2">Actualizar</a></td>
					<td><a href="${path}/usuario/eliminar/${usuario.id}" class="btn btn-danger">Eliminar</a></td>
			</tr>
		</c:forEach>
		</tbody>
		
		</table>
		</div>
 	</div>
 	 <div class="myForm2">
 	 	<form:form  action="${path}/usuario/lista" method="post"  modelAttribute="<usuarios>,<roles>" >
 	 		<div class="modal fade" id="exampleModal" 
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Actualizar o Guardar</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
						  <div class="form-group">
					<label for="id" class="col-form-label">Codigo:</label>
					<input type="text" class="form-control" id="id" name="id" value=""/>
				  </div>
				
				  <div class="form-group">
					<label for="usuarioNombre" class="col-form-label">Nombre Usuario:</label>
					<input type="text" class="form-control" id="usuarioNombre" name="usuarioNombre" value=""/>
				  </div>
				  <div class="form-group">
					<label for="clave" class="col-form-label">Clave</label>
					<input type="text" class="form-control" id="clave" name="clave"  value=""/>
				  </div>
				
				  
				   <div class="form-group">
					   <label for="rol" class="col-form-label">Rol:</label>
					 
						<select name="rol.id" id="rol" required>
							<c:forEach items="${roles}" var="rol" >
							
								<option value="${rol.id}">${rol.nombre}</option>
							</c:forEach>
						</select>	
					</div>
							

		
			 </div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
				<input type="submit" class="btn btn-primary" value="guardar"/>
			  </div>
		</div>
			
		  </div>
		   
		</div>
 	 
 	 </form:form>
 	 
 	 </div>
 	
 	
	</div>
</body>
</html>