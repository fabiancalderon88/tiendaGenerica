package co.tienda.generica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.tienda.generica.model.Proveedor;
import co.tienda.generica.repository.ProveedorRepository;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
	
	private final Logger logg = LoggerFactory.getLogger(Proveedor.class);
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "proveedores";
	}
	
	@GetMapping("/createProveedor") 
	public String create() {
		return "createProveedor";
	}
	
	@GetMapping("/reporteProveedor")
	public String reporteProveedor(Model model) {
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "reporteProveedores";
	}
	
	@PostMapping("/save")
	public String save(Proveedor proveedor) {
		logg.info("Información del Proveedor, {}",  proveedor);
		proveedorRepository.save(proveedor);
		return "redirect:/proveedores";
	}
	
	@GetMapping("/editProveedor/{nitproveedor}")
	public String edit (@PathVariable Integer nitproveedor, Model model) {
		Proveedor p = proveedorRepository.getOne(nitproveedor);
		model.addAttribute("proveedor", p);
		logg.info("Objeto recuperado {}", p);
		return "editProveedor";
	}
	
	
	@GetMapping("/delete/{nitproveedor}")
	public String delete(@PathVariable Integer nitproveedor) {
		Proveedor p = proveedorRepository.getOne(nitproveedor);
		logg.info("Objeto eliminado{}",p);
		proveedorRepository.delete(p);
		return "redirect:/proveedores";
	}
	
}