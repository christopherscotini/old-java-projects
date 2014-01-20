package br.com.utmanager.persistence.jpa.impl;

import java.math.BigDecimal;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.utmanager.model.Financa;
import br.com.utmanager.persistence.dao.FinancaDAO;
import br.com.utmanager.persistence.jpa.JpaGenericDao;

@Repository
public class FinancaDAOImpl extends JpaGenericDao<Financa, Long> implements FinancaDAO{

	@Override
	public BigDecimal getSaldoAtual() {
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT f.valorAtual FROM Financa f ");
		query.append(" ORDER BY f.valorAtual DESC");
		query.append("");

		try{
			BigDecimal saldo = (BigDecimal) getEntityManager().createQuery(query.toString()).setMaxResults(1).getSingleResult();
			return saldo;
		}catch(NoResultException nre){
			return BigDecimal.ZERO;
		}
		
	}

}
