package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Servico;

public interface ServicoService extends Serializable {

	void salvar(Servico servico);

	List<Servico> listar(Servico servico);

	List<Servico> listarAtivos();
}
