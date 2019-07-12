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
<title>Avicola Ventura</title>

</head>
<body>

<br>
<br>
	<div class="container">
	
	 <button  class="btn btn-primary nBtn1" >Nuevo</button>
 		  <br>
 		  <br>
	<div class="card">
 	<div class="card-block">
 	
 	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Descripcion</th>
				<th>Actualizar</th>
				<th>Eliminar</th>	
			</tr>
		
		</thead>
		<tbody>
			<c:forEach items="${medidas}" var="medida">
				<tr>
					<td>${medida.id}</td>
					<td>${medida.descripcion}</td>
					
					<td><a href="${path}/medida/actualizar/(id=${medida.id})" class="btn btn-primary eBtn1">Actualizar</a></td>
					<td><a href="${path}/medida/eliminar/${medida.id}"  class="btn btn-danger">Eliminar</a></td>
				</tr>
			
			</c:forEach>
		
		</tbody>
		
		
		
	</table>
 	</div>
 	</div>
 	
 	 <div class="myForm1">

 	<form:form  action="${path}/medida/agregar" method="post"  modelAttribute="medidas">
 		
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
					<label for="descripcion" class="col-form-label">Descripcion:</label>
					<input type="text" class="form-control" id="descripcion" name="descripcion"  value=""/>
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