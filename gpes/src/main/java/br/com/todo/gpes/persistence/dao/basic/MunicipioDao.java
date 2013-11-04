package br.com.todo.gpes.persistence.dao.basic;

import java.util.List;

import br.com.todo.gpes.model.basic.Municipio;
import br.com.todo.gpes.persistence.dao.Dao;

public interface MunicipioDao extends Dao<Municipio, Integer>{
	
	List<Municipio> findByCodigoEstado(Integer codigoEstado, Integer codigoPais);
}
