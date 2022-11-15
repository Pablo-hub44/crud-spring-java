package com.joses.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joses.demo.interfaceService.IpersonaService;
import com.joses.demo.modelo.Persona;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import java.util.List;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")//seria como mostrar
	public String listar(Model model) {
		List<Persona>personas= service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	//nuevo
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		return "formulario";
	}
	@PostMapping("/guardar")//como esta en el formulario
	public String guardar(@Validated Persona p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	//editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		java.util.Optional<Persona>persona = service.listarId(id);
		model.addAttribute("persona", persona);
		return "formulario";
	}
	
	
	//eliminar
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	
}
