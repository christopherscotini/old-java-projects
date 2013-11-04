package br.com.todo.gpes.persistence.dao.cadastro;

import java.util.List;

import br.com.todo.gpes.model.cadastro.Cargo;
import br.com.todo.gpes.persistence.dao.Dao;

public interface CargoDao extends Dao<Cargo, Integer> {

	List<Cargo> findByDescricao(String descricao);
}
