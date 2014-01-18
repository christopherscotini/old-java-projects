package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.Jogador;
import br.com.utmanager.persistence.dao.JogadorDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class JogadorDAOImpl extends JpaGenericDao<Jogador, Long> implements JogadorDAO{

	@Override
	@Transactional
	public List<Jogador> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT j FROM Jogador j");
		query.append(" ORDER BY j.dataEntrada ASC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
