package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.StatusJogador;
import br.com.utmanager.persistence.dao.StatusJogadorDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class StatusJogadorDAOImpl extends JpaGenericDao<StatusJogador, Long> implements StatusJogadorDAO{

	@Override
	@Transactional
	public List<StatusJogador> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT s FROM StatusJogador s");
		query.append(" ORDER BY s.descricao ASC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
