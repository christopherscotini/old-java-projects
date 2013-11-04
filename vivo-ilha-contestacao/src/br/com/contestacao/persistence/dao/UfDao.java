package br.com.contestacao.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.contestacao.model.Uf;
import br.com.contestacao.persistence.Dao;

public class UfDao implements Serializable {

	private static final long serialVersionUID = 8114528912796540874L;

	@Inject
	private Dao genericDao = null;

	public List<Uf> findAll() {
		return genericDao.findAll(Uf.class);
	}
}
