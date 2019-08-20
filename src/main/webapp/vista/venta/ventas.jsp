<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<%@include file="/template/header.jsp"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${path}/css/bootstrap.min.css">

<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/popper.min.js"></script>

<script type="text/javascript" src="${path}/js/main.js"></script>
<title>Modulo Ventas</title>
</head>
<body>
	<br> 
	<div class="container">
		<br> Modulo Ventas
		<br>
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline-secondary">
					<div class="card-body">
						<form:form action="${path}/venta/numeracion" method="POST"  modelAttribute="<facturas>,<numFactura>,<tcomprobantes>">
							<div class="form-group row">
								<label for="codigo" class="control-label col-md-2">Codigo</label>
								<div class="col-md-2">
									<input type="text" class="form-control" id="codigo" value="00${codigo}" autofocus />
								</div>
								<label for="fecha" class="col-md-1 control-label">Fecha</label>
								<div class="col-md-2">
									<input type="date" class="form-control" id="fecha" autofocus />
								</div>
							</div>
							<div class="form-group row">
								<label for="tipocomprobante" class="control-label col-md-2">Tipo
									Comprobante</label>

								<div class="col-md-2">
									<select name="tipocomprobante" id="tipocomprobante" required>
												<option value="-1">Comprobante</option>
										<c:forEach items="${tcomprobantes}" var="tipocomprobante">
											<option value="${tipocomprobante.idtipocomprobante}">${tipocomprobante.descripcion}</option>
										</c:forEach>
									</select>
								</div>
								<label for="serie" class="control-label col-md-1">Serie</label>
								<div class="col-md-2">
									<input type="text" class="form-control" id="serie" autofocus />
								</div>
								<label for="numFactura" class="control-label col-md-1">Numero</label>
								<div class="col-md-2">
									<input type="text" class="form-control" id="numFactura" value="00000${numFactura}" autofocus ></input>
								</div>
							</div>
							<div class="form-group row">
								<label for="cliente" class="control-label col-md-2">Cliente</label>

								<div class="col-md-2">
									<select name="cliente" id="cliente" required>
										<c:forEach items="clientes" var="cliente">

											<option value="">Eliga cliente</option>
										</c:forEach>
									</select>
								</div>

								<label for="moneda" class="control-label col-md-1">Moneda</label>

								<div class="col-md-2">
									<select name="moneda" id="moneda" required>
										<c:forEach items="monedas" var="moneda">

											<option value="">Eliga moneda</option>
										</c:forEach>
									</select>
								</div>


								<label for="tventa" class="control-label col-md-1">Tipo
									venta</label>

								<div class="col-md-2">
									<select name="tventa" id="tventa" required>
										<c:forEach items="tventas" var="tventas">

											<option value="">Eliga tipo de venta</option>
										</c:forEach>
									</select>
								</div>

							</div>

							<div class="form-group row">
								<label for="producto" class="control-label col-sm-2">Producto</label>

								<div class="col-sm-2">
									<select name="producto" id="producto" required>
										<c:forEach items="productos" var="productos">

											<option value="">Eliga productos</option>
										</c:forEach>
									</select>
								</div>
								<label for="peso" class="control-label col-sm">Peso</label>
								<div class="col-sm">
									<input type="text" class="form-control" id="peso" autofocus />
								</div>
								<label for="precio" class="control-label col-sm-1">Precio</label>
								<div class="col-sm-1">
									<input type="text" class="form-control" id="precio" autofocus />
								</div>
								<label for="total" class="control-label col-sm-1">Total</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="total" autofocus />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3">
									<input type="submit" class="btn btn-primary" value="agregar" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline-secondary">
					<div class="card-body">
						<form class="form" autocomplete="off">

							<table class="table table-hover table-bordered">
								<thead>
									<tr>
										<th>Id</th>
										<th>Cantidad</th>
										<th>Codigo</th>
										<th>Producto</th>
										<th>Precio unitario</th>
										<th>Peso</th>
										<th>Total</th>
										<th>Retirar</th>
									</tr>

								</thead>
								<tbody>

								</tbody>


							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline-secondary">
					<div class="card-body">
						<form class="form" autocomplete="off">

							<div class="form-group row">
								<label for="cantidad" class="control-label col-sm-1">Sub
									total</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="cantidad" autofocus />
								</div>
							</div>
							<div class="form-group row">
								<label for="cantidad" class="control-label col-sm-1">Descuento</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="cantidad" autofocus />
								</div>
							</div>
							<div class="form-group row">
								<label for="cantidad" class="control-label col-sm-1">I.G.V</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="cantidad" autofocus />
								</div>
							</div>
							<div class="form-group row">
								<label for="cantidad" class="control-label col-sm-1">Total</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="cantidad" autofocus />
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>




</body>
</html>