package br.com.contestacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.contestacao.model.Servico;
import br.com.contestacao.model.ServicoEnum;
import br.com.contestacao.model.TipoTarifa;
import br.com.contestacao.persistence.dao.TipoTarifaDao;
import br.com.contestacao.service.TipoTarifaService;

public class TipoTarifaServiceImpl implements TipoTarifaService {

	private static final long serialVersionUID = -2106698297064319969L;

	@Inject
	private TipoTarifaDao tipoTarifaDao = null;

	@Override
	public List<TipoTarifa> findByServico(Servico servico) {
		return tipoTarifaDao.findByServico(atribuirIdServico(servico));
	}

	private Long atribuirIdServico(Servico servico) {
		if(servico.isInternetOutrosServicos()) {
			return ServicoEnum.INTERNET_OUTROS_SERVICOS.getCodigo();
		}

		return servico.getId();
	}
}
