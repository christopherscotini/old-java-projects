package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.ClubeJogador;


public interface ClubeJogadorBO {
	
	List<ClubeJogador> listarTodos();
	void inserir(ClubeJogador categoria);
	void editar(ClubeJogador categoria);
	void deletar(ClubeJogador categoria);
	List<ClubeJogador> filtrarPorLiga(Long clube);

}
