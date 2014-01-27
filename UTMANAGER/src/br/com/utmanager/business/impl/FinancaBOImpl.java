package br.com.utmanager.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.FinancaBO;
import br.com.utmanager.business.exceptions.FormInconsistenteException;
import br.com.utmanager.model.Financa;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.view.utils.GlobalUtils;

@Service
public class FinancaBOImpl extends GenericBO implements FinancaBO{

	@Override
	public BigDecimal getSaldoAtual() {

		return getFinancaDao().getSaldoAtual();
	}

	@Override
	public BigDecimal getLucroTransferenciaAtual() {
		return getFinancaDao().getLucroTotalTransferencias();
	}

	@Override
	public BigDecimal getGastoTotalTransferencia() {
		return getFinancaDao().getGastoTotalTransferencias();
	}

	@Override
	public BigDecimal getGanhoTotalTransferencias() {
		return getFinancaDao().getGanhoTotalTransferencias();
	}

	@Override
	public BigDecimal getGanhoTotalPartidas() {
		return getFinancaDao().getGanhoTotalPartidas();
	}

	@Override
	public BigDecimal getGanhoTotalPremiacoes() {
		return getFinancaDao().getGanhoTotalPremiacoes();
	}

	@Override
	public BigDecimal getGastoTotalOutros() {
		return getFinancaDao().getGastoTotalOutros();
	}
	
	@Override
	public List<Financa> getExtrato() {
		return getFinancaDao().findAll();
	}
	
	@Override
	public void adicionarPremiacao(Financa premiacaoCadastro) {
		if(GlobalUtils.isBigDecimalNullOrZero((premiacaoCadastro.getValorMovimentado()))){
			throw new FormInconsistenteException("Informe o valor da premiação.");
		}
		premiacaoCadastro.setDataMovimentacao(new Date());
		premiacaoCadastro.setTipoMovimentacao(TipoMovimentacaoEnum.GANHO_TORNEIO);
		premiacaoCadastro.setValorAtual(getSaldoAtual().add(premiacaoCadastro.getValorMovimentado()));
		getFinancaDao().insert(premiacaoCadastro);
	}

	@Override
	public void adicionarItemClube(Financa itemCadastro) {
		
		if(GlobalUtils.isBigDecimalNullOrZero((itemCadastro.getValorMovimentado()))){
			throw new FormInconsistenteException("Informe o valor do item.");
		}
		
		itemCadastro.setDataMovimentacao(new Date());
		itemCadastro.setTipoMovimentacao(TipoMovimentacaoEnum.COMPRA_OUTROS);
		itemCadastro.setValorAtual(getSaldoAtual().subtract(itemCadastro.getValorMovimentado()));
		getFinancaDao().insert(itemCadastro);
		
	}
	
}
