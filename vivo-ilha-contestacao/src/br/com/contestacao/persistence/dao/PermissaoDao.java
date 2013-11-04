package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Permissao;
import br.com.contestacao.persistence.Dao;

public class PermissaoDao implements Serializable {

	private static final long serialVersionUID = -5854291617398930252L;

	@Inject
	private Dao genericDao = null;

	public List<Permissao> findByTela(List<Long> telasId) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Permissao> criteriaQuery = criteriaBuilder.createQuery(Permissao.class);

		Root<Permissao> rootPermissao = criteriaQuery.from(Permissao.class);

		if (telasId != null && !telasId.isEmpty()) {
			criteriaQuery.where(rootPermissao.join("tela").get("id").in((telasId)));
		}

		return genericDao.findAll(criteriaQuery);
	}
}
