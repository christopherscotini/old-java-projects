package br.com.utmanager.business.bo;

import java.math.BigDecimal;
import java.util.List;

import br.com.utmanager.model.Financa;

public interface FinancaBO {
	
	BigDecimal getSaldoAtual();

	BigDecimal getLucroTransferenciaAtual();

	BigDecimal getGastoTotalTransferencia();

	BigDecimal getGanhoTotalTransferencias();

	BigDecimal getGanhoTotalPartidas();

	BigDecimal getGanhoTotalPremiacoes();

	BigDecimal getGastoTotalOutros();

	List<Financa> getExtrato();

	void adicionarPremiacao(Financa premiacaoCadastro);

}
