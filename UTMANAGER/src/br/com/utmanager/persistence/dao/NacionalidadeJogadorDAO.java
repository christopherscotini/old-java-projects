package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.NacionalidadeJogador;
import br.com.utmanager.persistence.Dao;

public interface NacionalidadeJogadorDAO extends Dao<NacionalidadeJogador, Long>{

	List<NacionalidadeJogador>findAll();
	
}
