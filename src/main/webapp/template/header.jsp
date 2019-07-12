<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Avicola Ventura</title>
 <link rel="stylesheet" type="text/css"  href="${path}/css/bootstrap.min.css">

			<script  type="text/javascript"  src="js/jquery.min.js"></script>
			<script    type="text/javascript"  src="${path}/js/bootstrap.min.js"></script>			
			<script   type="text/javascript" src="${path}/js/popper.min.js"></script>  	
  


</head>
<body>
  
  <nav class="navbar navbar-expand-sm bg-success navbar-dark">
  
  
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Inicio
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="${path}">Pagina Inicio</a>
          <a class="dropdown-item" href="${path}/empleado/login?logout">Salir</a>
          <a class="dropdown-item" href="#">Informacion</a>
        </div>
      </li>
      
        <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Almacen
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Almacen</a>
          <a class="dropdown-item" href="#">Salir</a>
          <a class="dropdown-item" href="#">Informacion</a>
        </div>
      </li>
      
      
        <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Compras
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Compras</a>
          <a class="dropdown-item" href="#">Salir</a>
          <a class="dropdown-item" href="#">Informacion</a>
        </div>
      </li>
      
      
        <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Ventas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="${path}/venta/ventas">Ventas</a>
       
        </div>
      </li>
      
        <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Contabilidad
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Contabilidad</a>
          <a class="dropdown-item" href="#">Salir</a>
          <a class="dropdown-item" href="#">Informacion</a>
        </div>
      </li>
      
       <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Tesoreria
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Tesoreria</a>
          <a class="dropdown-item" href="#">Salir</a>
          <a class="dropdown-item" href="#">Informacion</a>
        </div>
      </li>
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Recursos Humanos
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Provisiones</a>
          <a class="dropdown-item" href="#">AFP.Net</a>
          <a class="dropdown-item" href="#">T-Registro</a>
          <a class="dropdown-item" href="#">Centro Costos</a>
          <a class="dropdown-item" href="#">Parametros</a>
          <a class="dropdown-item" href="#">Tabla General</a>
          <a class="dropdown-item" href="#">Control Asistencias</a>
          <a class="dropdown-item" href="#">Control Vacaciones</a>
          <a class="dropdown-item" href="#">Seleccion Personal</a>
          <a class="dropdown-item" href="${path}/recursoshumanos/empleados">Empleados</a>
          <a class="dropdown-item" href="#">Planillas</a>
          <a class="dropdown-item" href="#">Asignacion Conceptos</a>
        </div>
      </li>
       <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Mantenimiento
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
           <a class="dropdown-item" href="#">Almacen</a>
           <a class="dropdown-item" href="#">Tienda</a>
           <a class="dropdown-item" href="#">Empresa</a>
           <a class="dropdown-item" href="#">Productos</a>
           <a class="dropdown-item" href="#">Categorias</a>
           <a class="dropdown-item" href="${path}/mantenimiento/cliente">Clientes</a> 
           <a class="dropdown-item" href="#">Proveedores</a> 
           <a class="dropdown-item" href="#">Forma de pago</a>
           <a class="dropdown-item" href="#">Bancos</a>
           <a class="dropdown-item" href="#">Moneda</a>
           <a class="dropdown-item" href="#">Descuentos</a>
           <a class="dropdown-item" href="#">Supervisores</a>
           <a class="dropdown-item" href="#">Lotes</a>
           <a class="dropdown-item" href="${path}/mantenimiento/pais">Pais</a>
           <a class="dropdown-item" href="${path}/mantenimiento/departamento">Departamento</a>
          <a class="dropdown-item" href="${path}/mantenimiento/provincia">Provincia</a>
          <a class="dropdown-item" href="${path}/mantenimiento/distrito">Distrito</a>
          <a class="dropdown-item" href="${path}/direccion/lista">Direccion</a>
          <a class="dropdown-item" href="${path}/mantenimiento/tipocomprobante">Tipo Comprobante</a>
          <a class="dropdown-item" href="${path}/mantenimiento/tipocliente">Tipo Cliente</a>
          <a class="dropdown-item" href="${path}/mantenimiento/tipodocumento">Tipo Documento</a>
           <a class="dropdown-item" href="${path}/mantenimiento/genero">Genero</a>
           <a class="dropdown-item" href="${path}/mantenimiento/estadocivil">Estado Civil</a>
            <a class="dropdown-item" href="${path}/mantenimiento/gradoinstruccion">Grado instruccion</a>
        </div>
        
      
      
     
           <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Informes
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
        	
          <a class="dropdown-item" href="#">Utilidades</a>
          <a class="dropdown-item" href="#">Salir</a>
          <a class="dropdown-item" href="#">Informacion</a>
        </div>
      </li>
      
    
        <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Sistemas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="${path}/usuario/lista">Usuario</a>
<%--           <a class="dropdown-item" href="${path}/usuario/form">Agregar Usuario</a> --%>
           <a class="dropdown-item" href="${path}/medida/lista">Lista Medida</a>
        
        </div>
      </li>
      
    </ul>
    <div>
      <span class="navbar-text right">
   			<c:if test="${pageContext.request.userPrincipal.name !=null}">
		<form method="post" id="logoutForm" action="${path}/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		
		
		<p>Bienvenido ${pageContext.request.userPrincipal.name}|
		<a href="javascript:void(0);">cambiar contraseña</a>| 
		<a href="javascript:void(0);" onclick="document.forms['logoutForm'].submit()">Cerrar Sesion</a></p>
		
	</c:if>
 		 </span>
 		 </div>
  </div>
</nav>

   
    </body>

</html>