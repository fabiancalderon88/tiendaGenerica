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

import co.tienda.generica.model.Usuario;
import co.tienda.generica.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	private final Logger logg = LoggerFactory.getLogger(Usuario.class);
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuarios";
	}
	
	@GetMapping("/createUsuario") 
	public String create() {
		return "createUsuario";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		logg.info("Información del usuario, {}",  usuario);
		usuarioRepository.save(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/editUsuario/{cedula_usuario}")
	public String edit (@PathVariable Integer cedula_usuario, Model model) {
		Usuario p = usuarioRepository.getOne(cedula_usuario);
		model.addAttribute("usuario", p);
		logg.info("Objeto recuperado {}", p);
		return "editUsuario";
	}
	
	
	@GetMapping("/delete/{cedula_usuario}")
	public String delete(@PathVariable Integer cedula_usuario) {
		Usuario p = usuarioRepository.getOne(cedula_usuario);
		logg.info("Objeto eliminado{}",p);
		usuarioRepository.delete(p);
		return "redirect:/Usuarios";
	}
	
}
