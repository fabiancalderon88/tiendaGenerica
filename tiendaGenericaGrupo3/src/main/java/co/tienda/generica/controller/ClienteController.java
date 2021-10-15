package co.tienda.generica.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.tienda.generica.model.Cliente;
import co.tienda.generica.repository.ClienteRepository;

@Validated
@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	private final Logger logg = LoggerFactory.getLogger(Cliente.class);
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("clientes", clienteRepository.findAll());
		return "clientes";
	}
	
	@GetMapping("/createCliente") // http://localhost:8383/productos/create
	public String create() {
		return "createCliente";
	}
	
	@PostMapping("/save")
	public String save(@Valid Cliente cliente, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			logg.info("Error, {}",  bindingResult.hasErrors());
			return "createProducto";
		}else {
			logg.info("Información del cliente, {}",  cliente);
			clienteRepository.save(cliente);
			return "redirect:/clientes";
		}

	}
	
	@GetMapping("/editCliente/{cedula_cliente}")
	public String edit (@PathVariable Integer cedula_cliente, Model model) {
		Cliente p = clienteRepository.getOne(cedula_cliente);
		model.addAttribute("cliente", p);
		logg.info("Objeto recuperado {}", p);
		return "editCliente";
	}
	
	
	@GetMapping("/delete/{cedula_cliente}")
	public String delete(@PathVariable Integer cedula_cliente) {
		Cliente p = clienteRepository.getOne(cedula_cliente);
		logg.info("Objeto eliminado{}",p);
		clienteRepository.delete(p);
		return "redirect:/clientes";
	}

}
