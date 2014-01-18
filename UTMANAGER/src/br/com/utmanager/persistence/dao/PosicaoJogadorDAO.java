package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.PosicaoJogador;
import br.com.utmanager.persistence.Dao;

public interface PosicaoJogadorDAO extends Dao<PosicaoJogador, Long>{

	List<PosicaoJogador>findAll();
	
}
