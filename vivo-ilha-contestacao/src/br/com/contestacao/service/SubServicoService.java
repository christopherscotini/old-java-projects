package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.SubServico;

public interface SubServicoService extends Serializable {

	void salvar(SubServico subServico);

	List<SubServico> listar(SubServico subServico);

	List<SubServico> listarAtivos();

	List<SubServico> listarAtivos(Long idServico);

}
