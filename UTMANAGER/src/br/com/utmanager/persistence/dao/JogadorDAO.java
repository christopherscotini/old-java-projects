package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.Jogador;
import br.com.utmanager.persistence.Dao;

public interface JogadorDAO extends Dao<Jogador, Long>{

	List<Jogador>findAll();
	
}
