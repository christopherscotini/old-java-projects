package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Contrato;
import br.com.contestacao.persistence.Dao;

public class ContratoDao implements Serializable {

	private static final long serialVersionUID = -3077364152956925370L;

	@Inject
	private Dao genericDao = null;

	public Contrato save(Contrato contrato) {
		return genericDao.save(contrato);
	}

	public List<Contrato> findAll() {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Contrato> criteriaQuery = criteriaBuilder.createQuery(Contrato.class);

		Root<Contrato> root = criteriaQuery.from(Contrato.class);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("descricao")));

		return genericDao.findAll(criteriaQuery);
	}

	public Contrato findById(Long id) {
		return genericDao.findById(Contrato.class, id);
	}
}
