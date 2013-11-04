package br.com.todo.gpes.persistence.dao.cadastro;

import java.util.List;

import br.com.todo.gpes.model.cadastro.TipoContato;
import br.com.todo.gpes.persistence.dao.Dao;

public interface TipoContatoDao extends Dao<TipoContato, Integer> {
	List<TipoContato> findByDescricao(String descricao, String situacao);
	
}
