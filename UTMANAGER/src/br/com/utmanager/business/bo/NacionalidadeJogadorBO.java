package br.com.utmanager.business.bo;

import java.util.List;

import br.com.utmanager.model.NacionalidadeJogador;

public interface NacionalidadeJogadorBO {
	
	List<NacionalidadeJogador> listarTodos();
	void inserir(NacionalidadeJogador nacionalidade);
	void editar(NacionalidadeJogador nacionalidade);
	void deletar(NacionalidadeJogador nacionalidade);

}
