package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.Partida;

public interface PartidasBO {
	
	List<Partida> listarTodos();
	void inserir(Partida partida);
	void editar(Partida partida);
	void deletar(Partida partida);

}
