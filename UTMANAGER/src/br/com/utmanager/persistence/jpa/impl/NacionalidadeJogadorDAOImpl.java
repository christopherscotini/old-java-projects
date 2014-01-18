package br.com.utmanager.persistence.jpa.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.model.NacionalidadeJogador;
import br.com.utmanager.persistence.dao.NacionalidadeJogadorDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class NacionalidadeJogadorDAOImpl extends JpaGenericDao<NacionalidadeJogador, Long> implements NacionalidadeJogadorDAO{

	@Override
	@Transactional
	public List<NacionalidadeJogador> findAll() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT n FROM NacionalidadeJogador n");
		query.append(" ORDER BY n.descricao ASC");
		query.append("");
		query.append("");
		
		return getEntityManager().createQuery(query.toString()).getResultList();
	}
	
}
