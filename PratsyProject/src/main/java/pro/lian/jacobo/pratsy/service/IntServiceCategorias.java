package pro.lian.jacobo.pratsy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pro.lian.jacobo.pratsy.entity.Categoria;

public interface IntServiceCategorias {

	public List<Categoria> obtenerCategorias();
	public void guardar (Categoria categoria);
	public Categoria buscarPorId (Integer idCategoria);
	public void eliminar (Integer idCategoria);
	public int numeroCategorias();
	Page<Categoria>buscarTodas(Pageable page);
}
