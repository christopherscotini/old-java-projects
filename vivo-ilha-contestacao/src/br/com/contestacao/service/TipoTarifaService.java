package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Servico;
import br.com.contestacao.model.TipoTarifa;

public interface TipoTarifaService extends Serializable {

	List<TipoTarifa> findByServico(Servico servico);

}
