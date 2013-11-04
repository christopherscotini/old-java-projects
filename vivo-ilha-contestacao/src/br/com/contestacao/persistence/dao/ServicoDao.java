package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Servico;
import br.com.contestacao.model.SimNaoEnum;
import br.com.contestacao.persistence.Dao;

public class ServicoDao implements Serializable {

	private static final long serialVersionUID = -690393404713099940L;

	@Inject
	private Dao genericDao = null;

	public void save(Servico servico) {
		genericDao.save(servico);
	}

	public List<Servico> findByDescricao(Servico servico) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Servico> criteriaQuery = criteriaBuilder.createQuery(Servico.class);

		Root<Servico> rootServico = criteriaQuery.from(Servico.class);
		Expression<String> expressionDesc = rootServico.get("descricao");

		if (servico.getDescricao() != null) {
			String descricao = String.format("%%%s%%", servico.getDescricao());
			criteriaQuery.where(criteriaBuilder.like(expressionDesc, descricao));
		}

		criteriaQuery.orderBy(criteriaBuilder.asc(expressionDesc));

		return genericDao.findAll(criteriaQuery);
	}

	public List<Servico> findAtivos() {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Servico> criteriaQuery = criteriaBuilder.createQuery(Servico.class);

		Root<Servico> rootServico = criteriaQuery.from(Servico.class);

		Expression<String> expressionAtivo = rootServico.get("ativo");
		criteriaQuery.where(criteriaBuilder.equal(expressionAtivo, SimNaoEnum.S));

		Expression<String> expressionDesc = rootServico.get("descricao");
		criteriaQuery.orderBy(criteriaBuilder.asc(expressionDesc));

		return genericDao.findAll(criteriaQuery);
	}
}
