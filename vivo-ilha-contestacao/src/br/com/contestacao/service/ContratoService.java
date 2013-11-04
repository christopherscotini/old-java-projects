package br.com.contestacao.service;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Contrato;

public interface ContratoService extends Serializable {

	List<Contrato> listar();

}
