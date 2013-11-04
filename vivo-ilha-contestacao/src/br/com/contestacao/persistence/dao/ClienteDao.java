package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import br.com.contestacao.model.Cliente;
import br.com.contestacao.model.Contrato;
import br.com.contestacao.persistence.Dao;

public class ClienteDao implements Serializable {

	private static final long serialVersionUID = 1765505807741979387L;

	@Inject
	private Dao genericDao = null;

	public Cliente save(Cliente cliente) {
		return genericDao.save(cliente);
	}

	public List<Cliente> findAll() {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);

		Root<Cliente> root = criteriaQuery.from(Cliente.class);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));

		return genericDao.findAll(criteriaQuery);
	}

	public List<Cliente> findByCnpj(String cnpj) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);

		Root<Cliente> root = criteriaQuery.from(Cliente.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("cnpj"), cnpj));

		return genericDao.findAll(criteriaQuery);
	}

	public boolean existeChave(String cnpj, String uf, String chaveContrato) {
		CriteriaBuilder criteriaBuilder = genericDao.getCriteriaBuilder();
		CriteriaQuery<Contrato> criteriaQuery = criteriaBuilder.createQuery(Contrato.class);

		Root<Contrato> root = criteriaQuery.from(Contrato.class);
		Join<Contrato, Cliente> joinCliente = root.join("cliente");

		criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("descricao"), chaveContrato),
				criteriaBuilder.equal(joinCliente.get("cnpj"), cnpj), criteriaBuilder.equal(joinCliente.join("uf").get("id"), uf)));

		try {
			genericDao.find(criteriaQuery);
		} catch (NoResultException e) {
			return false;
		}
		return true;
	}
}
