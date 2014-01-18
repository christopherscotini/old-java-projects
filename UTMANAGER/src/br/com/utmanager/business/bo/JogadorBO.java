package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.Jogador;

public interface JogadorBO {

	List<Jogador> listarTodos();
	void inserir(Jogador plantel);
	void editar(Jogador plantel);
	void deletar(Jogador plantel);
	
}
