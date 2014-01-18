package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.CategoriaJogador;
import br.com.utmanager.persistence.dao.CategoriaJogadorDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class CategoriaJogadorDAOImpl extends JpaGenericDao<CategoriaJogador, Long> implements CategoriaJogadorDAO{

	@Override
	@Transactional
	public List<CategoriaJogador> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT c FROM CategoriaJogador c");
		query.append(" ORDER BY c.descricao ASC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
