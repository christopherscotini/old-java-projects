package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Contrato;
import br.com.contestacao.model.ContratoServico;
import br.com.contestacao.persistence.Dao;

public class ContratoServicoDao implements Serializable {

	private static final long serialVersionUID = 5427436051940361892L;

	@Inject
	private Dao genericDao = null;

	public void save(ContratoServico contratoServico) {
		genericDao.save(contratoServico);
	}

	public void remove(ContratoServico contratoServico) {
		genericDao.remove(contratoServico);
	}
	
	public List<ContratoServico> findByContrato(Long idContrato) {
		CriteriaBuilder criteria = genericDao.getCriteriaBuilder();
		CriteriaQuery<ContratoServico> query = criteria.createQuery(ContratoServico.class);

		Root<ContratoServico> root = query.from(ContratoServico.class);
		Join<ContratoServico, Contrato> joinContrato = root.join("contrato");

		query.where(criteria.equal(joinContrato.get("id"), idContrato));

		return genericDao.findAll(query);
	}
}