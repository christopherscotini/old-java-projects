package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.PosicaoJogador;
import br.com.utmanager.persistence.dao.PosicaoJogadorDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class PosicaoJogadorDAOImpl extends JpaGenericDao<PosicaoJogador, Long> implements PosicaoJogadorDAO{

	@Override
	@Transactional
	public List<PosicaoJogador> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT p FROM PosicaoJogador p");
		query.append(" ORDER BY p.sigla ASC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
