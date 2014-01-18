package br.com.utmanager.persistence.dao;

import java.util.List;

import br.com.utmanager.model.CategoriaJogador;
import br.com.utmanager.persistence.Dao;

public interface CategoriaJogadorDAO extends Dao<CategoriaJogador, Long>{

	List<CategoriaJogador>findAll();
	
}
