package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.StatusJogador;
import br.com.utmanager.persistence.Dao;

public interface StatusJogadorDAO extends Dao<StatusJogador, Long>{

	List<StatusJogador>findAll();

}
