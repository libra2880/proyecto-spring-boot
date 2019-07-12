<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/template/header.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${path}/css/bootstrap.min.css">

<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/popper.min.js"></script>

<script type="text/javascript" src="${path}/js/main.js"></script>

<%-- <script   type="text/javascript" src="${path}/js/main.js"></script> --%>


</head>
<body>
	<br>

	<div class="container">

	
		<br>
		<button class="btn btn-primary nBtn9">Nuevo</button>
				<br>
				<br>
				
			<div class="card">
				<div class="card-block">
					<table  class="table table-hover table-bordered" style="font-size:12px">
						<thead>
						<tr>
							<th>Codigo</th>	
							<th>Nombres</th>					
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Fecha nacimiento</th>
							<th>Direccion</th>
							<th>Email</th>
							<th>Celular</th>
							<th>Telefono</th>
							<th>Ruc</th>
						
						</tr>
		
			</thead>
		<tbody>
			<c:forEach items="${empleados}" var="empleado">
				<tr>
					<td>${empleado.idempleado}</td>	
					<td>${empleado.nombre}</td>				
					<td>${empleado.appaterno}</td>
					<td>${empleado.apmaterno}</td>
					
					<td>${empleado.fechanac}</td>
					<td>${empleado.direccion}</td>
					<td>${empleado.email}</td>
					<td>${empleado.celular}</td>
					<td>${empleado.telefono}</td>
				 	<td>${empleado.ruc}</td> 					
				</tr>
			
			</c:forEach>
		
		
		</tbody>		
	</table>
			</div>
		</div>
		
		<div class="myForm9">
 	 	<form:form  action="${path}/mantenimiento/agregarempleado" method="post"  modelAttribute="empleados">
 	 		<div class="modal fade" id="exampleModal" 
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		
		  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Actualizar o Guardar</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
				  <div class="form-group row">
						<label for="idempleado" class="control-label col-md-2">Codigo:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="idcliente" name="idcliente" value=""/>
				 	</div>
				  </div>
				
				  <div class="form-group row">
						<label for="nombre" class="control-label col-md-2">Nombre:</label>
					<div class="col-md-4">
						<input type="text" class="form-control" id="nombre" name="nombre" value=""/>
					</div>
					<label for="appaterno" class="control-label col-md-2">Apellido paterno:</label>
					<div class="col-md-4">
						<input type="text" class="form-control" id="appaterno" name="appaterno" value=""/>
					</div>
				 
				  </div>
				   <div class="form-group row">
						<label for="apmaterno" class="control-label col-md-2">Apellido materno:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="apmaterno" name="apmaterno" value=""/>
						</div>
						<label for="fechanac" class="control-label col-md-2">Fecha nacimiento:</label>
						<div class="col-md-4">
							<input type="date" class="form-control" id="fechanac" name="fechanac" value=""/>
						</div>
					</div>
				  
				  	  <div class="form-group row">
						<label for="usuario_nombre" class="control-label col-md-2">Usuario:</label>
					<div class="col-md-4">
						<input type="text" class="form-control" id="usuario_nombre" name="usuario_nombre" value=""/>
					</div>
					<label for="clave" class="control-label col-md-2">Clave:</label>
					<div class="col-md-4">
						<input type="password" class="form-control" id="clave" name="clave" value=""/>
					</div>
				 
				  </div>
				  
				  
				  <div class="form-group row">
						<label for="direccion" class="control-label col-md-2">Direccion:</label>
					<div class="col-md-10">
						<input type="text" class="form-control" id="direccion" name="direccion" value=""/>
					</div>
			
					
				  </div>
				  <div class="form-group row">
						    <label for="tipovia" class="control-label col-md-2">Tipo vía:</label>
							<div class="col-md-2">
								<input type="text" class="form-control" id="tipovia" name="tipovia" value=""/>
							</div>
							<label for="numero" class="control-label col-md-2">Numero:</label>
							<div class="col-md-2">
								<input type="text" class="form-control" id="numero" name="numero" value=""/>
							</div>
							<label for="interior" class="control-label col-md-2">Interior:</label>
							<div class="col-md-2">
								<input type="text" class="form-control" id="interior" name="interior" value=""/>
							</div>
				    </div>
				 
					<div class="form-group row">
					  <label for="direccion" class="control-label col-md-2">Nombre vía</label>
						<div class="col-md-10">
							  <input type="text" class="form-control" id="direccion"  autofocus="autofocus" />
						</div>
					</div>	
					
					<div class="form-group row">
													<label for="tipozona" class="control-label col-md-2">Tipo
														zona</label>
													<div class="col-md-4">
														<input type="text" class="form-control" id="tipozona"
															autofocus="autofocus" />
													</div>
													<label for="email" class="control-label col-md-2">Email</label>
													<div class="col-md-4">
														<input type="text" class="form-control" id="email"
															autofocus="autofocus" />
													</div>
													
												</div>
												<div class="form-group row">
													<label for="nombrezona" class="control-label col-md-2">Nombre
														zona</label>
													<div class="col-md-10">
														<input type="text" class="form-control" id="nombrezona"
															autofocus="autofocus" />
													</div>
												</div>
												<div class="form-group row">
													<label for="referencia" class="control-label col-md-2">Referencia</label>
													<div class="col-md-10">
														<input type="text" class="form-control" id="referencia"
															autofocus="autofocus" />
													</div>
												</div>
												<div class="form-group row">

													<label for="comboboxestadocivil" class="control-label col-md-2">Estado civil</label>

													<div class="col-md-4">
														<select name="comboboestadocivil" id="comboboxestadocivil" required>
															<option value="-1">Seleccione estado civil</option>
															<c:forEach items="${estadocivils}" var="estadocivil">
																<option value="${estadocivil.idestadocivil}">${estadocivil.nombre}</option>
															</c:forEach>
														</select>
													</div>

													<label for="genero" class="control-label col-md-2">Genero</label>

													<div class="col-md-4"> 
														<select name="comboboxgenero" id="comboboxDepartamento" required>
															<option value="0">Seleccione Genero</option>
															<c:forEach items="${generos}" var="genero">
																<option value="${genero.idgenero}">${genero.nombre}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label for="document" class="control-label col-md-2">Documento</label>

													<div class="col-md-4">
														<select name="comboboxdocument" id="comboboxdocument" required>
															<option value="0">Seleccione Documento</option>
															<c:forEach items="${documents}" var="document">
																<option value="${document.idtipodocu}">${document.descripcioncorta}</option>
															</c:forEach>
														</select>
													</div>

													<label for="ruc" class="control-label col-md-2"> N° </label>

													<div class="col-md-4">
														<input type="text" class="form-control" id="ruc"
															autofocus="autofocus" />
													</div>
												</div>	
												
				 <div class="form-group row">
						<label for="celular" class="control-label col-md-2">Celular:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="celular" name="celular" value=""/>
						</div>
						<label for="telefono" class="control-label col-md-2">Telefono:</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="telefono" name="telefono" value=""/>
						</div>
				 
				  </div>  
				  
				  	<div class="form-group row">
				  		
							<label for="ginstruccion" class="control-label col-md-2">Grado instruccion</label>

													<div class="col-md-4">
														<select name="comboboxginstruccion" id="comboboxginstruccion" required>
															<option value="0">Seleccione grado instruccion</option>
															<c:forEach items="${gradoinstruccions}" var="gradoinstruccion">
																<option value="${gradoinstruccion.idgradoins}">${gradoinstruccion.nombre}</option>
															</c:forEach>
														</select>
													</div>

													
												</div>	
				
							

		
			 </div>
			<div class="modal-footer justify-content-center" >
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