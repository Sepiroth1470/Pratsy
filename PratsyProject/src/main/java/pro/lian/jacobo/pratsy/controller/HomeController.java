package pro.lian.jacobo.pratsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pro.lian.jacobo.pratsy.service.IntServiceCategorias;

@Controller
public class HomeController {

	@Autowired
	private IntServiceCategorias serviceCategorias;
	
	@GetMapping("/")
	public String mostrarIndex(Model model) {
		model.addAttribute("Categorias", serviceCategorias.obtenerCategorias());
		return "home";
	}
}
