package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Servico;
import br.com.contestacao.model.TipoTarifa;
import br.com.contestacao.persistence.Dao;

public class TipoTarifaDao implements Serializable {

	private static final long serialVersionUID = -6983812703488149105L;

	@Inject
	private Dao genericDao = null;

	public List<TipoTarifa> findByServico(Long idServico) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<TipoTarifa> criteriaQuery = criteriaBuilder.createQuery(TipoTarifa.class);

		Root<TipoTarifa> root = criteriaQuery.from(TipoTarifa.class);

		if(idServico != null) {
			Join<TipoTarifa, Servico> joinServico = root.join("servico");
			criteriaQuery.where(criteriaBuilder.equal(joinServico.get("id"), idServico));
		}

		return genericDao.findAll(criteriaQuery);
	}

	
}