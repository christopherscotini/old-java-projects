package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Tarifa;

public interface TarifaService extends Serializable {

	List<Tarifa> listarPorClienteUfContrato(Long idCliente, String idUf, Long idContrato);

}
