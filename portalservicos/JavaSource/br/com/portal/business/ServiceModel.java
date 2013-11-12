package br.com.portal.business;

import java.util.List;


public interface ServiceModel<T> {

	public List<T> listarTodos();
	T adicionarEntidade(T entidade);
	T editarEntidade(T entidade);
	
}
