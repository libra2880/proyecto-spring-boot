
$(document).ready(function(){
	$('.nBtn3, .table .eBtn3').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		var text=$(this).text();
		if(text=='Actualizar'){
			
			$.get(href,function(pais,status){
				
				$('.myForm3 #id').val(pais.idpais);
				$('.myForm3 #descripcion').val(pais.nompais);
			});
			
			$('.myForm3 #exampleModal').modal();
		}else{
			
			$('.myForm3 #idpais').val('');
			$('.myForm3 #nompais').val('');
			
			$('.myForm3 #exampleModal').modal();
			
		}
		
		
		
	});
});

$(document).ready(function(){
	$('.nBtn1, .table .eBtn1').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		var text=$(this).text();
		if(text=='Actualizar'){
			
			$.get(href,function(medida,status){
				
				$('.myForm1 #id').val(medida.id);
				$('.myForm1 #descripcion').val(medida.descripcion);
			});
			
			$('.myForm1 #exampleModal').modal();
		}else{
			
			$('.myForm1 #id').val('');
			$('.myForm1 #descripcion').val('');
			
			$('.myForm1 #exampleModal').modal();
			
		}
		
		
		
	});
});

$(document).ready(function(){
	
	$('.nBtn, .table .eBtn').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(direccion,status){
			$('.myForm #id').val(direccion.id);
			$('.myForm #ciudad').val(direccion.ciudad);
			$('.myForm #distrito').val(direccion.distrito);
			$('.myForm #pais').val(direccion.ciudad);
			$('.myForm #usuario.id').val(direccion.usuario.id);
		});
		
		$('.myForm #exampleModal').modal();
	
	}else{
		
		$('.myForm #id').val('');
		$('.myForm #ciudad').val('');
		$('.myForm #distrito').val('');
		$('.myForm #pais').val('');
		$('.myForm #usuario').val('');
		
		$('.myForm #exampleModal').modal();
	}
	
	});
});


$(document).ready(function(){
	
	$('.nBtn2, .table .eBtn2').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(usuario,rol,status){
			$('.myForm2 #id').val(usuario.id);
			$('.myForm2 #usuarioNombre').val(usuario.usuarioNombre);
			$('.myForm2 #clave').val(usuario.clave);
			$('.myForm2 #rol').val(usuario.rol);
		
		});
		
		$('.myForm2 #exampleModal').modal();
	
	}else{
		
		$('.myForm2 #id').val('');
		$('.myForm2 #usuarioNombre').val('');
		$('.myForm2 #clave').val('');
		$('.myForm2 #rol').val('');
	
		
		$('.myForm2 #exampleModal').modal();
	}
	
	});
});



$(document).ready(function(){
	
	$('.nBtn4, .table .eBtn4').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(distrito,status){
			$('.myForm4 #iddistrito').val(distrito.iddistrito);
			$('.myForm4 #nomdistrito').val(distrito.nomdistrito);
		
			$('.myForm4 #provincia.idprovincia').val(distrito.provincia.idprovincia);
		});
		
		$('.myForm4 #exampleModal').modal();
	
	}else{
		
		$('.myForm4 #iddistrito').val('');
		$('.myForm4 #nomdistrito').val('');
		$('.myForm4 #provincia').val('');
		
		$('.myForm4 #exampleModal').modal();
	}
	
	});
});




$(document).ready(function(){
	
	$('.nBtn5, .table .eBtn5').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(departamento,status){
			$('.myForm5 #iddepartamento').val(departamento.iddepartamento);
			$('.myForm5 #nomdepartamento').val(departamento.nomdepartamento);
		
			$('.myForm5 #pais.idpais').val(departamento.pais.idpais);
		});
		
		$('.myForm5 #exampleModal').modal();
	
	}else{
		
		$('.myForm5 #iddepartamento').val('');
		$('.myForm5 #nomdepartamento').val('');
		$('.myForm5 #pais').val('');
		
		$('.myForm5 #exampleModal').modal();
	}
	
	});
});

$(document).ready(function(){
	
	$('.nBtn6, .table .eBtn6').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(provincia,status){
			$('.myForm6 #idprovincia').val(departamento.iddepartamento);
			$('.myForm6 #nomprovincia').val(departamento.nomdepartamento);
		
			$('.myForm6 #departamento.iddepartamento').val(provincia.departamento.iddepartamento);
		});
		
		$('.myForm6 #exampleModal').modal();
	
	}else{
		
		$('.myForm6 #idprovincia').val('');
		$('.myForm6 #nomprovincia').val('');
		$('.myForm6 #departamento').val('');
		
		$('.myForm6 #exampleModal').modal();
	}
	
	});
});


$(document).ready(function(){
	
	$('.nBtn7, .table .eBtn7').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(tipocomprobante,status){
			$('.myForm7 #codigo').val(tipocomprobante.codigo);
			$('.myForm7 #descripcion').val(tipocomprobante.descripcion);
		
			$('.myForm7 #abrev').val(tipocomprobante.abrev);
		});
		
		$('.myForm7 #exampleModal').modal();
	
	}else{
		
		$('.myForm7 #codigo').val('');
		$('.myForm7 #descripcion').val('');
		$('.myForm7 #abrev').val('');
		
		$('.myForm7 #exampleModal').modal();
	}
	
	});
});

$(document).ready(function(){
	
	$('.nBtn8, .table .eBtn8').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(tipocliente,status){
			$('.myForm8 #idtipocliente').val(tipocliente.idtipocliente);
			$('.myForm8 #descripcion').val(tipocliente.descripcion);
					
		});
		
		$('.myForm8 #exampleModal').modal();
	
	}else{
		
		$('.myForm8 #idtipocliente').val('');
		$('.myForm8 #descripcion').val('');
	
		
		$('.myForm8 #exampleModal').modal();
	}
	
	});
});


$(document).ready(function(){
	
	$('.nBtn9, .table .eBtn9').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(tipocliente,status){
			$('.myForm9 #idtipocliente').val(tipocliente.idtipocliente);
			$('.myForm9 #descripcion').val(tipocliente.descripcion);
					
		});
		
		$('.myForm9 #exampleModal').modal();
	
	}else{
		
		$('.myForm9 #idtipocliente').val('');
		$('.myForm9 #descripcion').val('');
	
		
		$('.myForm9 #exampleModal').modal();
	}
	
	});
});


$(document).ready(function(){
	
	$('.nBtn10, .table .eBtn10').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(tipodocumento,status){
			$('.myForm10 #idtipodocu').val(tipodocumento.idtipodocu);
			$('.myForm10 #descripcionlarga').val(tipodocumento.descripcionlarga);
			$('.myForm10 #descripcioncorta').val(tipodocumento.descripcioncorta);
					
		});
		
		$('.myForm10 #exampleModal').modal();
	
	}else{
		
		$('.myForm10 #idtipodocu').val('');
		$('.myForm10 #descripcionlarga').val('');
		$('.myForm10 #descripcioncorta').val('');
	
		
		$('.myForm10 #exampleModal').modal();
	}
	
	});
});


$(document).ready(function(){
	
	$('.nBtn11, .table .eBtn11').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(genero,status){
			$('.myForm11 #idgenero').val(genero.idgenero);
			$('.myForm11 #nombre').val(genero.nombre);
			
					
		});
		
		$('.myForm11 #exampleModal').modal();
	
	}else{
		
		$('.myForm11 #idgenero').val('');
		$('.myForm11 #nombre').val('');		
		$('.myForm11 #exampleModal').modal();
	}
	
	});
});



$(document).ready(function(){
	
	$('.nBtn12, .table .eBtn12').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(estadocivil,status){
			$('.myForm12 #idestadocivil').val(estadocivil.idestadocivil);
			$('.myForm12 #nombre').val(estadocivil.nombre);
			
					
		});
		
		$('.myForm12 #exampleModal').modal();
	
	}else{
		
		$('.myForm12 #idestadocivil').val('');
		$('.myForm12 #nombre').val('');		
		$('.myForm12 #exampleModal').modal();
	}
	
	});
});


$(document).ready(function(){
	
	$('.nBtn13, .table .eBtn13').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(gradoinstruccion,status){
			$('.myForm13 #idgradoins').val(gradoinstruccion.idgradoins);
			$('.myForm13 #nombre').val(gradoinstruccion.nombre);
			
					
		});
		
		$('.myForm13 #exampleModal').modal();
	
	}else{
		
		$('.myForm13 #idgradoins').val('');
		$('.myForm13 #nombre').val('');		
		$('.myForm13 #exampleModal').modal();
	}
	
	});
});




