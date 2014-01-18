package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.CategoriaJogador;

public interface CategoriaJogadorBO {
	
	List<CategoriaJogador> listarTodos();
	void inserir(CategoriaJogador categoria);
	void editar(CategoriaJogador categoria);
	void deletar(CategoriaJogador categoria);

}
