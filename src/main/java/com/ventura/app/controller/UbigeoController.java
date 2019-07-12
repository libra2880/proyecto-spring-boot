package com.ventura.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;
import com.ventura.app.model.Departamento;
import com.ventura.app.model.EstadoCivil;
import com.ventura.app.model.Genero;
import com.ventura.app.model.GradoInstruccion;
import com.ventura.app.model.Pais;
import com.ventura.app.model.TipoDocumento;
import com.ventura.app.service.DepartamentoService;
import com.ventura.app.service.DistritoService;
import com.ventura.app.service.EstadoCivilService;
import com.ventura.app.service.GeneroService;
import com.ventura.app.service.GradoInstruccionService;
import com.ventura.app.service.PaisService;
import com.ventura.app.service.ProvinciaService;
import com.ventura.app.service.TipoDocumentoService;

@RequestMapping("/recursoshumanos")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true, 
jsr250Enabled = true)
public class UbigeoController {
	
	private PaisService paisService;
	private DepartamentoService departamentoService;
	private ProvinciaService provinciaService;
	private DistritoService distritoService;
	private GeneroService generoService;
	private GradoInstruccionService gradoInstruccionService;
	private EstadoCivilService estadoCivilService;
	private TipoDocumentoService tipoDocumentoService;
	
	
	
	
	
	@Autowired
	public UbigeoController(PaisService paisService, DepartamentoService departamentoService,
			ProvinciaService provinciaService, DistritoService distritoService, GeneroService generoService,
			GradoInstruccionService gradoInstruccionService, EstadoCivilService estadoCivilService,
			TipoDocumentoService tipoDocumentoService) {
	
		this.paisService = paisService;
		this.departamentoService = departamentoService;
		this.provinciaService = provinciaService;
		this.distritoService = distritoService;
		this.generoService = generoService;
		this.gradoInstruccionService = gradoInstruccionService;
		this.estadoCivilService = estadoCivilService;
		this.tipoDocumentoService = tipoDocumentoService;
	}


	/*@GetMapping("/empleados")
	
	@ResponseStatus(value=HttpStatus.OK)
    public List<Departamento> ubigeoLista(
    Model model,
    @ModelAttribute("paises") Pais paises,
    @RequestParam(value="idpais" ,required=false) Long idpais,
    @ModelAttribute("lstStates") Departamento buslist
    		)throws Exception{
    	
	
	//model.addAttribute("idPais",departamentoService.findByPais(idPais));
	
	List<Departamento> bus_list= new ArrayList<>();
	bus_list=departamentoService.findByPais(idpais);
	
	model.addAttribute("lstStates", bus_list);
	model.addAttribute("paises",paisService.paisLista());
	
	return bus_list;
    	
    }*/
	
	
	
/*	@GetMapping("/empleados")
	@ResponseStatus(value=HttpStatus.OK)
    public Set<Departamento> ubigeoLista(
    		Model model,@ModelAttribute("paises") Pais paises ,@RequestParam(value="idPais",required=false) Long idPais	
    		)throws Exception{
    	
		 model.addAttribute("paises",paisService.paisLista());
		//
       model.addAttribute("idPais",departamentoService.findByPais1(idPais));
		return this.departamentoService.findByPais1(idPais);
    	
    }*/
	
	
	
	

	
/*	@GetMapping("/empleados")
	@ResponseStatus(value=HttpStatus.OK)
    public List<Departamento> ubigeoLista(
    		Model model,
    		@ModelAttribute("paises") Pais paises,
    		@RequestParam(value="idPais" ,required=false) Long idPais
    	    ,@ModelAttribute("pais") Pais pais
    		)throws Exception{
    	
		 model.addAttribute("paises",paisService.paisLista());
		
        model.addAttribute("pais",departamentoService.departamentoLista());
         
        // Pais pais=paisService.getPais(idPais).get();
         
		return departamentoService.findByPais(idPais);
    	
    }
*/
	@GetMapping("/empleados")
	@ResponseStatus(value=HttpStatus.OK)
	public String ubigeoLista
	(
	 Model model,
	@ModelAttribute("estadocivils") EstadoCivil estadoCivils,
	 @ModelAttribute("paises") Pais paises,
	 @ModelAttribute("generos") Genero generos,
	 @ModelAttribute("gradoinstruccions") GradoInstruccion gradoInstruccions,
	 @ModelAttribute("documents") TipoDocumento tipoDocumentos
			) {		
		 
	    model.addAttribute("paises",paisService.paisLista());
		model.addAttribute("generos",generoService.generoLista());
		model.addAttribute("estadocivils",estadoCivilService.estadoCivilLista());
		model.addAttribute("gradoinstruccions", gradoInstruccionService.gInstruccionLista());
		model.addAttribute("documents", tipoDocumentoService.tDocumentoLista());
		return "recursoshumanos/empleados";
		
	}
	
	
/*	@RequestMapping(value="/empleados/{idPais}" ,method=RequestMethod.GET)	
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List<Departamento> cargarDepartamentos(@RequestParam(value = "idPais", required = true) Long idPais) 
	{
		Gson gson=new Gson();
		
		return  idPais!=null? departamentoService.findByPais((idPais)):null;
		
	}*/
	
	@RequestMapping(value="/empleados/{idPais}" ,method=RequestMethod.GET)	
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public  List<Departamento> cargarDepartamentos(@PathVariable(value ="idPais") String idPais) 
	{
		Gson gson=new Gson();
		
		return  idPais!=null? departamentoService.findByPais(Long.valueOf(idPais)) :null;
		
	}
	
	/*@RequestMapping(value="/empleados/{idPais}" ,method=RequestMethod.GET )
	@ResponseBody	
	@ResponseStatus(value=HttpStatus.OK)
	public String empleados(@PathVariable("idPais") Long idPais) {
		
			Gson gson=new Gson();
		
		return gson.toJson(departamentoService.findByPais(idPais));
		
	}*/
	
	
/*	@RequestMapping(value="departamento" ,method=RequestMethod.GET)
	@ResponseBody
	public List<Departamento> cargarDepartamento(Model model) {
		
			
		
		
		
		
		return departamentoService.departamentoLista();
		
	}*/
	
	
	

}
