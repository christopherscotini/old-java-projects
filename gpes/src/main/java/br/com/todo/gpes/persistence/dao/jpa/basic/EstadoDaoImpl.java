package br.com.todo.gpes.persistence.dao.jpa.basic;

import org.springframework.stereotype.Repository;

import br.com.todo.gpes.model.basic.Estado;
import br.com.todo.gpes.persistence.dao.basic.EstadoDao;
import br.com.todo.gpes.persistence.dao.jpa.JpaGenericDao;

@Repository
public class EstadoDaoImpl extends JpaGenericDao<Estado, Integer> implements EstadoDao{

}
