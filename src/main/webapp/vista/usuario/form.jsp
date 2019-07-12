<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
</head>
<body>
	<form:form method="post" action="${path}/usuario/agregar" modelAttribute="usuarioForm">
			<form:hidden path="id"/>
		<p>Codigo :<form:input path="usuarioId" placeholder="Ingrese codigo usuario"/></p>
		<p>Nombre usuario :<form:input path="usuarioNombre" placeholder="Ingrese nombre usuario"/></p>
		<p>clave :<form:password  path="clave" placeholder="Ingrese Clave"/></p>
		<p>
			Rol :
			<form:select path="rol.id">
				<c:forEach items="${roles}" var="rol">
					<form:option value="${rol.id}">${rol.nombre}</form:option>
				</c:forEach>
			</form:select>	
		</p>
		<p>
			<form:button value="Guardar">Guardar</form:button>
			<a href="${path}/usuario/lista">lista usuarios></a>
		</form:form>

</body>
</html> --%>