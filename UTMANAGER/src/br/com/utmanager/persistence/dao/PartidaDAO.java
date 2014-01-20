package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.Partida;
import br.com.utmanager.persistence.Dao;

public interface PartidaDAO extends Dao<Partida, Long>{

	List<Partida>findAll();
	
}
