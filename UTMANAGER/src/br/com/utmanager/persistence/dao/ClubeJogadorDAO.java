package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.ClubeJogador;
import br.com.utmanager.persistence.Dao;

public interface ClubeJogadorDAO extends Dao<ClubeJogador, Long>{

	List<ClubeJogador>findAll();

	List<ClubeJogador> findByLeague(Long clube);
	
}
