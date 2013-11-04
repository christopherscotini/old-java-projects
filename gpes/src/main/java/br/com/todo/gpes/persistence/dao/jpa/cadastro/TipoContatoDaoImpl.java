package br.com.todo.gpes.persistence.dao.jpa.cadastro;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.todo.gpes.model.cadastro.TipoContato;
import br.com.todo.gpes.persistence.dao.cadastro.TipoContatoDao;
import br.com.todo.gpes.persistence.dao.jpa.JpaGenericDao;

@Repository
public class TipoContatoDaoImpl extends JpaGenericDao<TipoContato, Integer> implements TipoContatoDao {

	public List<TipoContato> findByDescricao(String descTipoContato, String situacao) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT c FROM TipoContato c ");
		query.append("WHERE c.descTipoContato LIKE '%" + descTipoContato + "%'");
		if(!"".equals(situacao)){
			query.append("AND c.situacao = '" + situacao + "'");
		}
		Query queryJpa = getEntityManager().createQuery(query.toString());
		return queryJpa.getResultList();
	}

}
