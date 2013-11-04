package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.SimNaoEnum;
import br.com.contestacao.model.SubServico;
import br.com.contestacao.persistence.Dao;

public class SubServicoDao implements Serializable {

	private static final long serialVersionUID = 6450788619629979873L;

	@Inject
	private Dao genericDao = null;

	public void save(SubServico subServico) {
		genericDao.save(subServico);
	}

	public List<SubServico> findByDescricao(SubServico subServico) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<SubServico> criteriaQuery = criteriaBuilder.createQuery(SubServico.class);

		Root<SubServico> rootSubServico = criteriaQuery.from(SubServico.class);
		Expression<String> expressionDesc = rootSubServico.get("descricao");

		if (subServico.getDescricao() != null) {
			String descricao = String.format("%%%s%%", subServico.getDescricao());
			criteriaQuery.where(criteriaBuilder.like(expressionDesc, descricao));
		}

		criteriaQuery.orderBy(criteriaBuilder.asc(expressionDesc));

		return genericDao.findAll(criteriaQuery);
	}

	public List<SubServico> findAtivos() {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<SubServico> criteriaQuery = criteriaBuilder.createQuery(SubServico.class);

		Root<SubServico> rootSubServico = criteriaQuery.from(SubServico.class);

		Expression<String> expressionAtivo = rootSubServico.get("ativo");
		criteriaQuery.where(criteriaBuilder.equal(expressionAtivo, SimNaoEnum.S));

		Expression<String> expressionDesc = rootSubServico.get("descricao");
		criteriaQuery.orderBy(criteriaBuilder.asc(expressionDesc));

		return genericDao.findAll(criteriaQuery);
	}

	public List<SubServico> findAtivos(Long idServico) {
		CriteriaBuilder criteria = genericDao.getCriteriaBuilder();
		CriteriaQuery<SubServico> query = criteria.createQuery(SubServico.class);

		Root<SubServico> root = query.from(SubServico.class);

		Expression<String> expressionAtivo = root.get("ativo");
		query.where(criteria.and(criteria.equal(expressionAtivo, SimNaoEnum.S),
				criteria.equal(root.join("servico").get("id"), idServico)));

		Expression<String> expressionDesc = root.get("descricao");
		query.orderBy(criteria.asc(expressionDesc));

		return genericDao.findAll(query);
	}
}
