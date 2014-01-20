package br.com.utmanager.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.JogadorBO;
import br.com.utmanager.model.Financa;
import br.com.utmanager.model.Jogador;
import br.com.utmanager.model.TipoMovimentacaoEnum;

@Service
public class JogadorBOImpl extends GenericBO implements JogadorBO{

	@Override
	public void inserir(Jogador plantel) {
		plantel.setDataEntrada(new Date());
		getJogadorDao().insert(plantel);
		
		calculaFinancas(plantel, TipoMovimentacaoEnum.COMPRA_JOGADOR);
	}

	@Override
	public void editar(Jogador plantel) {
		plantel.setDataAlteracao(new Date());
		
		if(plantel.getStatus().getId().equals(3L)){
			plantel.setDataSaida(new Date());
			calculosDeVenda(plantel);
			calculaFinancas(plantel, TipoMovimentacaoEnum.VENDA_JOGADOR);
		}else{
			calculaFinancas(plantel, TipoMovimentacaoEnum.COMPRA_OUTROS);
		}
		
		
		getJogadorDao().update(plantel);
		
	}

	@Override
	public void deletar(Jogador plantel) {
		plantel.setDataAlteracao(new Date());
		plantel.setDataSaida(new Date());

	}

	@Override
	public List<Jogador> listarTodos() {
		return getJogadorDao().findAll();
	}
	
	private void calculosDeVenda(Jogador jogador){
		BigDecimal valorVenda5Porcento = jogador.getValorVenda().multiply(new BigDecimal("0.05"));
		BigDecimal valorVendaDescontado = jogador.getValorVenda().subtract(valorVenda5Porcento);
		jogador.setLucro(valorVendaDescontado.subtract(jogador.getValorPago()));
	
	}

	private void calculaFinancas(Jogador plantel, TipoMovimentacaoEnum tipoMov) {

		Financa financa = new Financa();
		
		if(plantel.getValorVenda().compareTo(BigDecimal.ZERO) > 0){
			BigDecimal valorVenda5Porcento = plantel.getValorVenda().multiply(new BigDecimal("0.05"));
			BigDecimal valorVendaDescontado = plantel.getValorVenda().subtract(valorVenda5Porcento);
			financa.setValorMovimentado(valorVendaDescontado);
		}else{
			if(plantel.getValorPago().compareTo(BigDecimal.ZERO) > 0){
				financa.setValorMovimentado(plantel.getValorPago());
			}else{
				return;
			}
		}
		
		financa.setValorAtual(getFinancaDao().getSaldoAtual().add(financa.getValorMovimentado()));
		financa.setDataMovimentacao(new Date());
		financa.setTipoMovimentacao(tipoMov);
		getFinancaDao().insert(financa);
		
	}

}
