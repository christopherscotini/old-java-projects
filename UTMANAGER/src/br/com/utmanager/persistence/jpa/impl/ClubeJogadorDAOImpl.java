package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.ClubeJogador;
import br.com.utmanager.persistence.dao.ClubeJogadorDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class ClubeJogadorDAOImpl extends JpaGenericDao<ClubeJogador, Long> implements ClubeJogadorDAO{

	@Override
	@Transactional
	public List<ClubeJogador> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT c FROM ClubeJogador c");
		query.append(" ORDER BY c.descricao ASC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
	@Override
	public List<ClubeJogador> findByLeague(Long clube) {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT c FROM ClubeJogador c");
		query.append(" WHERE c.liga = "+clube);

		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
