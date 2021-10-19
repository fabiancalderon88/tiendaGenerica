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

import co.tienda.generica.model.Producto;
import co.tienda.generica.repository.ProductoRepository;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	private final Logger logg = LoggerFactory.getLogger(Producto.class);
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "productos";
	}
	
	@GetMapping("/createProducto")
	public String create() {
		return "createProducto";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@PostMapping("/save")
	public String save(Producto producto) {
		logg.info("Información del producto, {}",  producto);
		productoRepository.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/editProducto/{codigo_producto}")
	public String edit (@PathVariable Integer codigo_producto, Model model) {
		Producto p = productoRepository.getOne(codigo_producto);
		model.addAttribute("producto", p);
		logg.info("Objeto recuperado {}", p);
		return "editProducto";
	}
	
	
	@GetMapping("/delete/{codigo_producto}")
	public String delete(@PathVariable Integer codigo_producto) {
		Producto p = productoRepository.getOne(codigo_producto);
		p.setActive("F");
		productoRepository.save(p);
		logg.info("Objeto eliminado{}",p);
		return "redirect:/productos";
	}
}
