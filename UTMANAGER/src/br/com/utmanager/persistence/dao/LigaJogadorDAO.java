package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.LigaJogador;
import br.com.utmanager.persistence.Dao;

public interface LigaJogadorDAO extends Dao<LigaJogador, Long>{

	List<LigaJogador>findAll();
	
}
