<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estado Civil</title>
<%@include file="/template/header.jsp"%>
	<link rel="stylesheet" type="text/css"  href="${path}/css/bootstrap.min.css">
	<script  type="text/javascript"  src="${path}/js/jquery.min.js"></script>
	<script    type="text/javascript"  src="${path}/js/bootstrap.min.js"></script>			
	<script   type="text/javascript" src="${path}/js/popper.min.js"></script>  
	<script   type="text/javascript" src="${path}/js/main.js"></script>
</head>
<body>
		<br>
	<br>
	<div class="container">
 	<br>
 		 <button  class="btn btn-primary nBtn12" >Nuevo</button>
 		  <br>
 		  <br>
 	<div class="card">
 	<div class="card-block">
 	
 	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>Codigo</th>				
				<th>Nombre </th>
				
				
			</tr>
		
		</thead>
		<tbody>
			<c:forEach items="${estadocivils}" var="estadocivil">
				<tr>
					<td>${estadocivil.idestadocivil}</td>
					<td>${estadocivil.nombre}</td>
										
				</tr>			
			</c:forEach>		
		</tbody>		
	</table>
 	</div>
 	</div>
 	 <div class="myForm12">

 	<form:form  action="${path}/mantenimiento/agregarestadocivil" method="post"  modelAttribute="estadocivils" >
 		
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
					<label for="idestadocivil" class="col-form-label">Codigo:</label>
					<input type="text" class="form-control" id="idestadocivil" name="idestadocivil" value="" />
				  </div>
				
				  <div class="form-group">
					<label for="nombre" class="col-form-label">Nombre:</label>
					<input type="text" class="form-control" id="nombre" name="nombre" value=""/>
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