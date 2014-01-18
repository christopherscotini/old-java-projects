package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.LigaJogador;
import br.com.utmanager.persistence.dao.LigaJogadorDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class LigaJogadorDAOImpl extends JpaGenericDao<LigaJogador, Long> implements LigaJogadorDAO{

	@Override
	@Transactional
	public List<LigaJogador> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT l FROM LigaJogador l");
		query.append(" ORDER BY l.descricao ASC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
