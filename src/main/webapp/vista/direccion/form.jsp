<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direccion</title>
</head>
<body>
	<form:form method="post" action="${path}/direccion/agregar"  modelAttribute="direccionForm">
		<form:hidden path="id"/>
		<p>Pais :<form:input path="pais" placeholder="Ingrese Pais"/></p>
		<p>Ciudad :<form:input path="ciudad" placeholder="Ingrese Ciudad"/></p>
		<p>Distrito :<form:input path="distrito" placeholder="Ingrese Distrito"/></p>
		<p>Usuario :</p>
				<form:select path="usuario.id">
				<c:forEach items="${usuarios}" var="usuario">
					<form:option value="${usuario.id}">${usuario.usuarioNombre}</form:option>
				</c:forEach>
			</form:select>	
		<p>
			<form:button value="Guardar">Guardar</form:button>
			<a href="${path}/direccion/lista"></a>
		</form:form>

</body>
</html> --%>