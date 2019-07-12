package com.ventura.app.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ventura.app.model.Factura;
import com.ventura.app.service.FacturaService;

@RequestMapping("/venta")
@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class FacturaController {

	private FacturaService facturaService;

	@Autowired
	public FacturaController(FacturaService facturaService) {

		this.facturaService = facturaService;
	}
	
	

	@PostMapping("/ventas")
	public String numeracion(Model model,@Valid @ModelAttribute("numfact") Long numfact,@Valid @ModelAttribute("codigo") Long codigo,
			@ModelAttribute("facturas") Factura factura) {
		
		numfact=2L;
		codigo=2L;

		try {
		   comprobante(model,numfact, new Factura());
		   comprobante1(model,codigo, new Factura());
		   
			numfact = Long.valueOf(factura.getNumfact());
			codigo=Long.valueOf(factura.getCodigo());	
			
			numfact = facturaService.obtenerTotalRegistrosFactura();
			codigo=facturaService.obtenerTotalRegistrosFactura();

			if (numfact <= 0 || numfact == null ||codigo<=0 ||codigo==null) {
			//	comprobante(model, new Factura(), numFactura);
				numfact = Long.valueOf(1);
				codigo=Long.valueOf(1);

				model.addAttribute("numFactura1", numfact);
				model.addAttribute("codigo1",codigo);

				return "venta/ventas";
			} else {
				//comprobante(model, new Factura(), numFactura);

				factura = facturaService.obtenerUltimoRegistro();
				numfact = Long.valueOf(factura.getNumfact() + 1);
				codigo = Long.valueOf(factura.getCodigo() + 1);

				model.addAttribute("numFactura1", numfact);
				model.addAttribute("codigo1",codigo);
				return "venta/ventas";
			}
		} catch (Exception e) {

		} finally {

		}

		model.addAttribute("numFactura1", numfact);
		model.addAttribute("codigo1",codigo);

		return "/venta/ventas";
	}

	@GetMapping("/ventas")
	public String facturaLista(Model model, @ModelAttribute("facturas") Factura factura,
			@ModelAttribute("numFactura") Long numFactura) {

		numFactura = 2L;
		try {
			//comprobante(model, new Factura(), numFactura);
			numFactura = Long.valueOf(factura.getNumfact());

			numFactura = facturaService.obtenerTotalRegistrosFactura();

			if (numFactura <= 0 || numFactura == null) {

				numFactura = Long.valueOf(1);

				model.addAttribute("numFactura", numFactura);
				model.addAttribute("facturas", facturaService.facturaLista());
				return "venta/ventas";
			} else {

				factura = facturaService.obtenerUltimoRegistro();
				numFactura = Long.valueOf(factura.getNumfact() + 1);
				model.addAttribute("facturas", facturaService.facturaLista());
				model.addAttribute("numFactura", numFactura);
				return "venta/ventas";
			}

		} catch (Exception e) {

		}
		//comprobante(model, new Factura(), numFactura);
		return "venta/ventas";

	}

	@ModelAttribute
	public void comprobante(Model model,Long numfact,Factura factura) {
		
				
		numfact=facturaService.nextNro();
		
		model.addAttribute("numFactura",numfact);

	}
	@ModelAttribute
	public void comprobante1(Model model,Long codigo,Factura factura) {
		codigo=facturaService.nextNro();
		model.addAttribute("codigo",codigo);
		
	}
	
	
}
