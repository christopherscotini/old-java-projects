package br.com.contestacao.relatorio;

import br.com.contestacao.fatura.FaturaEletronica;

public interface GeradorRelatorioAnalise {

	byte[] gerarRelatorioAnalise(FaturaEletronica faturaEletronica);
}
