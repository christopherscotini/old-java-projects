package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.LigaJogador;

public interface LigaJogadorBO {
	
	List<LigaJogador> listarTodos();
	void inserir(LigaJogador liga);
	void editar(LigaJogador liga);
	void deletar(LigaJogador liga);

}
