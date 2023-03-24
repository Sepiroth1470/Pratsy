package pro.lian.jacobo.pratsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pro.lian.jacobo.pratsy.entity.Categoria;
import pro.lian.jacobo.pratsy.service.IntServiceCategorias;

@RequestMapping("/categorias")
@Controller
public class CategoriasController {
	
	@Autowired
	private IntServiceCategorias serviceCategorias;
	
	@GetMapping("/buscar")
	public String modificarCat(@RequestParam("id") int idCategoria, Model model) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@PostMapping("/guardar")
	public String guardar(Categoria categoria) {
		serviceCategorias.guardar(categoria);
		return "redirect:/categorias/index";	
	}
	
	@GetMapping("/nueva")
	public String nuevaCat(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCat(@RequestParam("id") int idCategoria, RedirectAttributes model) {
		serviceCategorias.eliminar(idCategoria);
		model.addFlashAttribute("msg", "Categoria Eliminada");
		return "redirect:/categorias/index";
	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria>categorias = serviceCategorias.obtenerCategorias();
		model.addAttribute("categorias", categorias);
		return "categorias/listaCategorias";
	}
	
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria> lista = serviceCategorias.buscarTodas(page);
	model.addAttribute("categorias", lista);
	model.addAttribute("total", serviceCategorias.obtenerCategorias().size());
	return "categorias/listaCategorias";
	}

}
