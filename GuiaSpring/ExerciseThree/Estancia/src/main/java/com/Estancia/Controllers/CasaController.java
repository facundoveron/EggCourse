package com.Estancia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Estancia.Entities.Casa;
import com.Estancia.Error.ErrorServicio;
import com.Estancia.Service.CasaService;

@Controller
@RequestMapping("/casa")
public class CasaController {
	
	@Autowired
	private CasaService casaService;
	
	@GetMapping("")
	public String listCasas(ModelMap model) {
		model.addAttribute("casas", casaService.listAllCasa());
		return "Casa";
	}
	
	@GetMapping("/registrar")
	public String registrar(ModelMap model) {
		model.addAttribute("casa", new Casa());
		return "RegistrarCasa";
	}
	
	@PostMapping("/registrar")
	public String registrarCasa(ModelMap model, @ModelAttribute Casa casa) throws ErrorServicio{
		try {
			casaService.registrar(casa);
		} catch (ErrorServicio e) {
			model.put("error", e.getMessage());
			model.put("calle", casa.getCalle());
			model.put("numero", casa.getNumero());
			model.put("codPostal", casa.getCodPostal());
			model.put("ciudad", casa.getCiudad());
			model.put("pais", casa.getPais());
			model.put("fechaDesde", casa.getFechaDesde());
			model.put("fechaHasta", casa.getFechaHasta());
			model.put("minDias", casa.getMinDias());
			model.put("maxDias", casa.getMaxDias());
			model.put("precio", casa.getPrecio());
			model.put("tipoVivienda", casa.getTipoVivienda());
			return "RegistrarCasa";
		}
		return "Casa";
	}
	
	@GetMapping("/alquilar/{parametro}")
	public String alquilar(@PathVariable("parametro") String idCasa) throws ErrorServicio{
		casaService.alquilar(idCasa);
		return "Exito";
	}
}
