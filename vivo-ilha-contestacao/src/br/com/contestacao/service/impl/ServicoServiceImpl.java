package br.com.contestacao.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.model.Servico;
import br.com.contestacao.persistence.dao.ServicoDao;
import br.com.contestacao.service.ServicoService;

@Stateless
public class ServicoServiceImpl implements ServicoService {

	private static final long serialVersionUID = -7544687031120432914L;

	@Inject
	private ServicoDao servicoDao = null;

	@Override
	public void salvar(Servico servico) {
		servicoDao.save(servico);
	}

	@Override
	public List<Servico> listar(Servico servico) {
		return servicoDao.findByDescricao(servico);
	}

	@Override
	public List<Servico> listarAtivos() {
		return servicoDao.findAtivos();
	}
}
