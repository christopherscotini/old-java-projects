package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Perfil;
import br.com.contestacao.persistence.Dao;

public class PerfilDao implements Serializable {

	private static final long serialVersionUID = 8104232307883042742L;

	@Inject
	private Dao genericDao = null;

	public void save(Perfil perfil) {
		genericDao.save(perfil);
	}

	public List<Perfil> findAll() {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Perfil> criteriaQuery = criteriaBuilder.createQuery(Perfil.class);

		Root<Perfil> root = criteriaQuery.from(Perfil.class);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));

		return genericDao.findAll(criteriaQuery);
	}
}
