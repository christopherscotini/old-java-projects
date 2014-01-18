package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.StatusJogador;

public interface StatusJogadorBO {
	
	List<StatusJogador> listarTodos();
	void inserir(StatusJogador status);
	void editar(StatusJogador status);
	void deletar(StatusJogador status);

}
