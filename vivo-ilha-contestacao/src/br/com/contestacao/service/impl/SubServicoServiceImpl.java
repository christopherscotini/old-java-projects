package br.com.contestacao.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.model.SubServico;
import br.com.contestacao.persistence.dao.SubServicoDao;
import br.com.contestacao.service.SubServicoService;

@Stateless
public class SubServicoServiceImpl implements SubServicoService {

	private static final long serialVersionUID = 7181214572724082225L;

	@Inject
	private SubServicoDao subServicoDao = null;

	@Override
	public void salvar(SubServico subServico) {
		subServicoDao.save(subServico);
	}

	@Override
	public List<SubServico> listar(SubServico subServico) {
		return subServicoDao.findByDescricao(subServico);
	}

	@Override
	public List<SubServico> listarAtivos() {
		return subServicoDao.findAtivos();
	}

	@Override
	public List<SubServico> listarAtivos(Long idServico) {
		return subServicoDao.findAtivos(idServico);
	}
}
