package br.com.contestacao.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.model.Contrato;
import br.com.contestacao.persistence.dao.ContratoDao;
import br.com.contestacao.service.ContratoService;

@Stateless
public class ContratoServiceImpl implements ContratoService {

	private static final long serialVersionUID = 2097050539971443745L;

	@Inject
	private ContratoDao contratoDao = null;

	@Override
	public List<Contrato> listar() {
		return contratoDao.findAll();
	}

}