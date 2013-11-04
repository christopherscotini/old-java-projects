package br.com.todo.gpes.persistence.dao.jpa.cadastro;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.todo.gpes.model.cadastro.Cargo;
import br.com.todo.gpes.persistence.dao.cadastro.CargoDao;
import br.com.todo.gpes.persistence.dao.jpa.JpaGenericDao;

@Repository
public class CargoDaoImpl extends JpaGenericDao<Cargo, Integer> implements CargoDao {

	public List<Cargo> findByDescricao(String descricao) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT c FROM Cargo c ");
		query.append("WHERE c.descCargo LIKE '%" + descricao + "%'");
		Query queryJpa = getEntityManager().createQuery(query.toString());
		return queryJpa.getResultList();
	}

}
