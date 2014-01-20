package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.Partida;
import br.com.utmanager.persistence.dao.PartidaDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class PartidaDAOImpl extends JpaGenericDao<Partida, Long> implements PartidaDAO{

	@Override
	@Transactional
	public List<Partida> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT p FROM Partida p");
		query.append(" ORDER BY p.dataPartida DESC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
