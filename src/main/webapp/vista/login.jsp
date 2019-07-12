<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Login</title>
			<link rel="stylesheet" type="text/css"  href="${path}/css/bootstrap.min.css">
			<script  type="text/javascript"  src="${path}/js/bootstrap.min.js"></script>
			<script  type="text/javascript"  src="${path}/js/jquery2.1.1.min"></script>

	<style type="text/css">
	body {
	
	background-image: url("../images/pollo.jpg"); 
	background-size:cover;
	align-items:center;
	align:center;
	height:100vh;
	display:flex;
	padding: 0 1rem;
	 margin: 1rem;

  justify-content: center;
 
}
	
	</style>

</head>
<body>
<%-- 		<img class="mx-auto d-block" style="width:50%" src="${path}/images/avicola.jpg"   /> --%>
			<div class="container">
				
				<div class="row align-items-center justify-content-center">
				
					<div class="col align-self-end col-md-4 col-md-offset-6">
						
						<div class="card bg-light text-dark">
							<div class="card-body text-center">
								<strong>Login Ingrese su cuenta Usuario</strong>
							</div>
							<div class="card-body text-center">
								<form action="${path}/empleado/login" method="post" class="form-signin  form-horizontal">
								
									
									
									
									<c:if test="${error !=null }">
										<div class="alert alert-danger">
											<strong>${error}</strong>
										</div>
										
									</c:if>
									<c:if test="${mensaje !=null}">
										<div class="alert alert-success">
											<strong>${mensaje}</strong>
										</div>
									
									</c:if>
									
									<div class="form-group">
									  <div class="col-md-12">
										<div class="input-group input-group-md">
											<span class="input-group-addon">
											<span class="glyphicon glyphicon-user"></span>
											</span>
												<input type="text" class="form-control" name="username" placeholder="Ingrese Usuario" autofocus="autofocus" /> 
											
											</div>
										</div>								
									
									</div>
									
									<div class="form-group">
										<div class="col-md-12">
											<div class="input-group input-group-md">
												<span class="input-group-addon">
											<span class="glyphicon glyphicon-lock"></span>
											</span>
													<input type="password"  class="form-control" name="password" placeholder="Ingrese Clave"/>
											
											</div>
										</div>								
									
									</div>
									<div class="form-group">
										<div class="col-md-6">
											<div class="checkbox">
												<label>
													<input type="checkbox" name="remember-me" id="remember-me"/> Recordarme
												</label>
											</div>
										</div>
									</div>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
									<div class="form-group">
										<div class="col-md-12">
											<button type="submit" class="btn btn-default btn-block">
											<span class="glyphicon glyphicon-log-in"></span>Ingresar</button>
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