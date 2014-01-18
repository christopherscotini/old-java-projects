package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.PosicaoJogador;

public interface PosicaoJogadorBO {
	
	List<PosicaoJogador> listarTodos();
	void inserir(PosicaoJogador posicao);
	void editar(PosicaoJogador posicao);
	void deletar(PosicaoJogador posicao);

}
