package br.com.contestacao.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.model.Uf;
import br.com.contestacao.persistence.dao.UfDao;
import br.com.contestacao.service.UfService;

@Stateless
public class UfServiceImpl implements UfService {

	private static final long serialVersionUID = 7146446057851436865L;

	@Inject
	private UfDao ufDao = null;

	@Override
	public List<Uf> listar() {
		return ufDao.findAll();
	}
}
