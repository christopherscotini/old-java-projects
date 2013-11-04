package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Cliente;
import br.com.contestacao.model.Contrato;
import br.com.contestacao.model.SubServico;
import br.com.contestacao.model.Tarifa;
import br.com.contestacao.model.Uf;
import br.com.contestacao.persistence.Dao;

public class TarifaDao implements Serializable {

	private static final long serialVersionUID = 8845648938163704924L;

	@Inject
	private Dao genericDao = null;

	public void save(Tarifa tarifa) {
		genericDao.save(tarifa);
	}

	public void remove(Tarifa tarifa) {
		genericDao.remove(tarifa);
	}

	public List<Tarifa> findByServicoSubServico(Long idServico, Long idSubServico) {
		CriteriaBuilder criteria = genericDao.getCriteriaBuilder();
		CriteriaQuery<Tarifa> query = criteria.createQuery(Tarifa.class);
		Root<Tarifa> root = query.from(Tarifa.class);

		Join<SubServico, Tarifa> joinSubServico = root.join("subServico");
		if (idSubServico != null && idSubServico > 0) {
			query.where(criteria.equal(joinSubServico.get("id"), idSubServico));
		} else if (idServico != null && idServico > 0) {
			query.where(criteria.equal(joinSubServico.join("servico").get("id"), idServico));
		}

		return genericDao.findAll(query);
	}

	public List<Tarifa> findByContrato(Long idContrato) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Tarifa> criteriaQuery = criteriaBuilder.createQuery(Tarifa.class);

		Root<Tarifa> root = criteriaQuery.from(Tarifa.class);

		criteriaQuery.where(criteriaBuilder.equal(root.join("contrato").get("id"), idContrato));

		return genericDao.findAll(criteriaQuery);
	}

	public List<Tarifa> findByClienteUfContrato(Long idCliente, String idUf, Long idContrato) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Tarifa> criteriaQuery = criteriaBuilder.createQuery(Tarifa.class);

		Root<Tarifa> root = criteriaQuery.from(Tarifa.class);
		Join<Tarifa, Contrato> joinContrato = root.join("contrato");
		Join<Contrato, Cliente> joinCliente = joinContrato.join("cliente");
		Join<Cliente, Uf> joinUf = joinCliente.join("uf");

		criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(joinContrato.get("id"), idContrato),
			criteriaBuilder.and(criteriaBuilder.equal(joinCliente.get("id"), idCliente),
							criteriaBuilder.equal(joinUf.get("id"), idUf))));

		return genericDao.findAll(criteriaQuery);
	}
}