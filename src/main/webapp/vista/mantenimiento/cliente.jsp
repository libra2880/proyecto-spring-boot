<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/template/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${path}/css/bootstrap.min.css">

<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/popper.min.js"></script>
<script type="text/javascript" src="${path}/js/main.js"></script>
</head>
<body>
		<br>
		<br>
		<div class="container">
			<br>
				<button class="btn btn-primary nBtn3">Nuevo</button>
				<br>
				<br>
			            
			
			<div class="card">
				<div class="card-block">
					<table  class="table table-hover table-bordered">
						<thead>
						<tr>
							<th>Codigo</th>						
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Nombres</th>
							<th>Fecha de Nacimiento</th>
							
							<th>Ruc</th>
							<th>Dni</th>
							<th>Razon Social</th>
							<th>Tipo de Cliente</th>
						
								
						</tr>
		
			</thead>
					<tbody>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.idcliente}</td>					
					<td>${cliente.appaterno}</td>
					<td>${cliente.apmaterno}</td>
					<td>${cliente.nombre}</td>
					<td>${cliente.fechanacimiento}</td>
				
				 	<td>${cliente.ruc}</td>   
				 	<td>${cliente.dni}</td>
				 	<td>${cliente.razonsocial}</td>
					<td>${cliente.tipocliente.descripcion}</td>
					
					
				</tr>
			
			</c:forEach>
		
		</tbody>		
	</table>
					
				</div>
			
			
			</div>	
	<div class="myForm3">
 	 	<form:form  action="${path}/mantenimiento/agregarcliente" method="post"  modelAttribute="<clientes>,<tipoclientes>">
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
						<label for="idcliente" class="control-label col-md-2">Codigo:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="idcliente" name="idcliente" value=""/>
				 	</div>
				  </div>
				
				  <div class="form-group row">
						<label for="nombre" class="control-label col-md-2">Nombre:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="nombre" name="nombre" value=""/>
					</div>
					<label for="appateno" class="control-label col-md-2">Apellido paterno:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="appateno" name="appateno" value=""/>
					</div>
					<label for="apmaterno" class="control-label col-md-2">Apellido materno:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="apmaterno" name="apmaterno" value=""/>
					</div>
					
				  </div>
				  <div class="form-group row">
						<label for="dni" class="control-label col-md-2">DNI:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="dni" name="dni" value=""/>
					</div>
					<label for="ruc" class="control-label col-md-2">RUC:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="ruc" name="ruc" value=""/>
					</div>
					<label for="razonsocial" class="control-label col-md-2">Razon social:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="razonsocial" name="razonsocial" value=""/>
					</div>
					
				  </div>
				    <div class="form-group row">
				    		<label for="email" class="control-label col-md-2">Correo electronico:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="email" name="email" value=""/>
					</div>
					<label for="telefono" class="control-label col-md-2">Telefono:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="telefono" name="telefono" value=""/>
					</div>
					<label for="celular" class="control-label col-md-2">Celular:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="celular" name="celular" value=""/>
					</div>
				    </div>
				  <div class="form-group row">
						<label for="fechanacimiento" class="control-label col-md-2">Fecha nacimiento:</label>
					<div class="col-md-2">
						<input type="text" class="form-control" id="fechanacimiento" name="fechanacimiento" value=""/>
					</div>
					
						
					<label for="tipocliente" class="control-label col-md-2">Tipo de Cliente</label>

								<div class="col-md-2">
									<select name="tipocliente" id="tipocliente" required>
										<c:forEach items="tipoclientes" var="tipocliente">

											<option value="">Eliga tipo de cliente </option>
										</c:forEach>
									</select>
								</div>
					</div>
					<div class="form-group row">
					  <label for="direccion" class="control-label col-md-2">Direccion</label>
							<div class="col-md-6">
							  <input type="text" class="form-control" id="direccion"  autofocus="autofocus" />
							</div>
					</div>	
					
					<div class="form-group row">
						<label for="domiciliado" class="control-label col-md-2">Domiciliado</label>
							<div class="col-md-2">
								<select name="domiciliado" id="domiciliado" required>
										<c:forEach items="domiciliados" var="domiciliado">
											<option value="">Elige domicilio</option>
										</c:forEach>
								</select>
							</div>	
					</div>	
					
					<div class="form-group row">
													<label for="tvia" class="control-label col-md-2">Tipo
														de Via</label>
													<div class="col-md-2">
														<input type="text" class="form-control" id="tvia"
															autofocus="autofocus" />
													</div>
													<label for="numero" class="control-label col-md-2">Numero</label>
													<div class="col-md-2">
														<input type="text" class="form-control" id="numero"
															autofocus="autofocus" />
													</div>
													<label for="interior" class="control-label col-md-2">Interior</label>
													<div class="col-md-2">
														<input type="text" class="form-control" id="interior"
															autofocus="autofocus" />
													</div>
												</div>
												<div class="form-group row">
													<label for="nvia" class="control-label col-md-2">Nombre
														vía</label>
													<div class="col-md-6">
														<input type="text" class="form-control" id="nvia"
															autofocus="autofocus" />
													</div>
												</div>
												<div class="form-group row">
													<label for="referencia" class="control-label col-md-2">Referencia</label>
													<div class="col-md-6">
														<input type="text" class="form-control" id="referencia"
															autofocus="autofocus" />
													</div>
												</div>
												<div class="form-group row">

													<label for="pais" class="control-label col-md-2">Pais</label>

													<div class="col-md-2">
														<select name="comboboxPais" id="comboboxPais" required>
															<option value="-1">Seleccione Pais</option>
															<c:forEach items="${paises}" var="pais">
																<option value="${pais.idpais}">${pais.nompais}</option>
															</c:forEach>
														</select>
													</div>

													<label for="departamento" class="control-label col-md-2">Departamento</label>

													<div class="col-md-2">
														<select name="comboboxDepartamento" id="comboboxDepartamento" required>
															<option value="0">Seleccione Departamento</option>
															<c:forEach items="${departamentos}" var="departamento">
																<option value="${departamento.iddepartamento}">${departamento.nomdepartamento}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group row">
													<label for="provincia" class="control-label col-md-2">Provincia</label>

													<div class="col-md-3">
														<select name="provincia.idprovincia" id="provincia" required>
															<option value="0">Seleccione Provincia</option>
															<c:forEach items="${provincias}" var="provincia">
																<option value="${provincia.idprovincia}">${provincia.nomprovincia}</option>
															</c:forEach>
														</select>
													</div>

													<label for="distito" class="control-label col-md-2">Distrito</label>

													<div class="col-md-2">
														<select name="distrito.iddistrito" id="distrito" required>
															<option value="0">Seleccione Distrito</option>
															<c:forEach items="${distritos}" var="distrito">
																<option value="${distrito.iddistrito}">${distrito.nomdistrito}</option>
															</c:forEach>
														</select>
													</div>
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