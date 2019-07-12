$(document).ready(function(){
	
	$('.nBtn, .table .eBtn').on('click',function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		
		if(text=='Actualizar' ){ 
			 
		
		$.get(href,function(direccion,usuario,status){
			$('.myForm #id').val(direccion.id);
			$('.myForm #ciudad').val(direccion.ciudad);
			$('.myForm #distrito').val(direccion.distrito);
			$('.myForm #pais').val(direccion.ciudad);
			$('.myForm #nombre').val(usuario,nombre);
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