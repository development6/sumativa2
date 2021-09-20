package com.sumativa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sumativa.models.Resumen;
import com.sumativa.services.ResumenService;

@Controller
@RequestMapping("/resumen")
public class ResumenController {

	//depen
	@Autowired
	private ResumenService rs;
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("resumen") Resumen resumen, Model model) {
		
		List<Resumen> listaResumens=rs.findAll();
		model.addAttribute("listaResumenes", listaResumens);
		return "resumen.jsp";
	}
	
	
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute("resumen") Resumen resumen) {
		System.out.println("insertar"+resumen);
		rs.insertarResumen(resumen);
		return "redirect:/resumen";
	}
	
	
	@RequestMapping(value="/eliminar")
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("Eliminar id: "+id);
		rs.eliminarResumen(id);
		return "redirect:/resumen";
	}
	
	
	@RequestMapping(value="/actualizar/{id}", method=RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("Actualizar id: "+id);
		Resumen resumen=rs.buscarResumen(id);
		
		model.addAttribute("resumen", resumen);
		return "editarResumen.jsp";
	}

	@RequestMapping(value="/modificar", method=RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("resumen") Resumen resumen) {
		System.out.println("el Id a modificar es: "+resumen.getId());
		rs.modificarResumen(resumen);
		return "redirect:/resumen";
	}


}
