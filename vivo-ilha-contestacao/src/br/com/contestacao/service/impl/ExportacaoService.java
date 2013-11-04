package br.com.contestacao.service.impl;

import java.io.Serializable;
import java.util.List;

import br.com.contestacao.model.Tarifa;

public interface ExportacaoService extends Serializable {

	byte[] exportar(byte[] arquivoFatura, List<Tarifa> tarifas);

}