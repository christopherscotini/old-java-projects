package br.com.utmanager.persistence.dao;

import java.math.BigDecimal;

import br.com.utmanager.model.Financa;
import br.com.utmanager.model.Jogador;
import br.com.utmanager.persistence.Dao;

public interface FinancaDAO extends Dao<Financa, Long>{

	BigDecimal getSaldoAtual();

	Financa recuperaMovimentacaoFinanceiraJogador(Jogador jogador);

	BigDecimal getLucroTotalTransferencias();

	BigDecimal getGastoTotalTransferencias();

	BigDecimal getGanhoTotalTransferencias();

	BigDecimal getGanhoTotalPartidas();

	BigDecimal getGanhoTotalPremiacoes();

	BigDecimal getGastoTotalOutros();

}
