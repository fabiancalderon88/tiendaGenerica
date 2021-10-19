package co.tienda.generica.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.tienda.generica.model.Cliente;
import co.tienda.generica.model.Ventas;
import co.tienda.generica.repository.ventasRepository;
import co.tienda.generica.service.IClienteService;

@Controller
@RequestMapping("/ventas")
public class VentaController {
	private final Logger logg = LoggerFactory.getLogger(Ventas.class);
	@Autowired
	private ventasRepository ventasRepository;
	@Autowired
	private IClienteService ClienteService;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("ventas", ventasRepository.findAll());
		return "ventas";
	}
	
	@GetMapping("/createVenta")
	public String create(Model model) {
		
		List<Cliente> lisClientes= ClienteService.ListaClientes();
		model.addAttribute("clientes",lisClientes);
		return "createVenta";
	}
	
	@PostMapping("/save")
	public String save(Ventas venta) {
		logg.info("Información de la venta, {}",  venta);
		ventasRepository.save(venta);
		return "redirect:/ventas";
	}
	
	@GetMapping("/editVenta/{codigo_venta}")
	public String edit (@PathVariable Integer codigo_venta, Model model) {
		Ventas v = ventasRepository.getOne(codigo_venta);
		model.addAttribute("venta", v);
		logg.info("Objeto recuperado {}", v);
		return "editVentas";
	}
	

}
