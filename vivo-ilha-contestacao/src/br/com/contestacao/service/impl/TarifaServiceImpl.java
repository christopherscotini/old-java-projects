package br.com.contestacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.contestacao.model.Tarifa;
import br.com.contestacao.persistence.dao.TarifaDao;
import br.com.contestacao.service.TarifaService;

public class TarifaServiceImpl implements TarifaService {

	private static final long serialVersionUID = 2553088922879937055L;

	@Inject
	private TarifaDao tarifaDao = null;

	@Override
	public List<Tarifa> listarPorClienteUfContrato(Long idCliente, String idUf, Long idContrato) {
		return tarifaDao.findByClienteUfContrato(idCliente, idUf, idContrato);
	}
}