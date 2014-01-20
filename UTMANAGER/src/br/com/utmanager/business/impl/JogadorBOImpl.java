package br.com.utmanager.business.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.JogadorBO;
import br.com.utmanager.business.exceptions.FormInconsistenteException;
import br.com.utmanager.model.Financa;
import br.com.utmanager.model.Jogador;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.view.utils.GlobalUtils;

@Service
public class JogadorBOImpl extends GenericBO implements JogadorBO{

	private final Long STATUS_VENDIDO = 3L;
	
	@Override
	public void inserir(Jogador plantel) {
		
		if(GlobalUtils.isBigDecimalNullOrZero(plantel.getValorVenda())){
			if(plantel.getStatus().equals(STATUS_VENDIDO)){
				throw new FormInconsistenteException("Adicione um valor de venda.");
			}
		}else{
			if(!plantel.getStatus().equals(STATUS_VENDIDO)){
				throw new FormInconsistenteException("Marque o STATUS como VENDIDO.");
			}
		}
		
		plantel.setDataEntrada(new Date());
		plantel = getJogadorDao().insert(plantel);
		
		calculaFinancas(plantel, TipoMovimentacaoEnum.COMPRA_JOGADOR);
	}

	@Override
	public void editar(Jogador plantel) {
		
		plantel.setDataAlteracao(new Date());

		if(plantel.getStatus().getId().equals(STATUS_VENDIDO)){
			plantel.setDataSaida(plantel.getDataSaida()==null?new Date():plantel.getDataSaida());
			calculosDeLucroJogador(plantel);
			calculaFinancas(plantel, TipoMovimentacaoEnum.VENDA_JOGADOR);
		}else{
			calculaFinancas(plantel, TipoMovimentacaoEnum.VENDA_JOGADOR);
		}
		
		plantel = getJogadorDao().update(plantel);
		
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
	
	private void calculosDeLucroJogador(Jogador jogador){
		BigDecimal valorVenda5Porcento = BigDecimal.ZERO;
		if(jogador.isLeilao()){
			valorVenda5Porcento = jogador.getValorVenda().multiply(new BigDecimal("0.05"));
		}
		BigDecimal valorVendaDescontado = jogador.getValorVenda().subtract(valorVenda5Porcento);
		jogador.setLucro(valorVendaDescontado.subtract(jogador.getValorPago()));
	
	}

	private void calculaFinancas(Jogador jogador, TipoMovimentacaoEnum tipoMov) {

		Financa financa = new Financa();

		if(jogador.isVendido()){
			financa = getFinancaDao().verificaMovimentacaoJogador(jogador);
			if(financa != null){
				calculaValorMovimentadoFinanca(financa, jogador);
				addDescricaoFinanca(financa, tipoMov);
				getFinancaDao().update(financa);
			}
		}else{
			financa = getFinancaDao().verificaMovimentacaoJogador(jogador);
			if(financa == null){
				if(!(GlobalUtils.isBigDecimalNullOrZero(jogador.getValorPago()) && GlobalUtils.isBigDecimalNullOrZero(jogador.getValorVenda()))){
					if(!GlobalUtils.isLongNull(jogador.getId())){
						if(!GlobalUtils.isBigDecimalNullOrZero(jogador.getValorVenda())){
							financa = new Financa();
							calculaValorMovimentadoFinanca(financa, jogador);
							financa.setValorAtual(getFinancaDao().getSaldoAtual().add(financa.getValorMovimentado()));
							financa.setDataMovimentacao(new Date());
							financa.setTipoMovimentacao(tipoMov);
							financa.setJogador(jogador);
							addDescricaoFinanca(financa, tipoMov);
							getFinancaDao().insert(financa);
						}else{
							if(!GlobalUtils.isBigDecimalNullOrZero(jogador.getValorPago())){
								financa = new Financa();
								calculaValorMovimentadoFinanca(financa, jogador);
								financa.setValorAtual(getFinancaDao().getSaldoAtual().subtract(financa.getValorMovimentado()));
								financa.setDataMovimentacao(new Date());
								financa.setTipoMovimentacao(tipoMov);
								financa.setJogador(jogador);
								addDescricaoFinanca(financa, tipoMov);
								getFinancaDao().insert(financa);
							}
						}
					}
				}
			}else{
				calculaValorMovimentadoFinanca(financa, jogador);
				financa.setValorAtual(financa.getValorAtual().add(financa.getValorMovimentado()));
				addDescricaoFinanca(financa, tipoMov);
				getFinancaDao().update(financa);
			}
		}
		
	}

	private void calculaValorMovimentadoFinanca(Financa financa, Jogador jogador) {
		
		if(jogador.getValorVenda().compareTo(BigDecimal.ZERO) > 0){
			BigDecimal valorVenda5Porcento = jogador.getValorVenda().multiply(new BigDecimal("0.05"));
			BigDecimal valorVendaDescontado = jogador.getValorVenda().subtract(valorVenda5Porcento);
			financa.setValorMovimentado(valorVendaDescontado);
		}else{
			if(jogador.getValorPago().compareTo(BigDecimal.ZERO) > 0){
				financa.setValorMovimentado(jogador.getValorPago());
			}else{
				return;
			}
		}
		
	}
	
	private void addDescricaoFinanca(Financa financa, TipoMovimentacaoEnum tipoMov){
		StringBuilder desc = new StringBuilder();
		if(tipoMov.equals(TipoMovimentacaoEnum.VENDA_JOGADOR)){
			desc.append("Venda do jogador ");
		}else{
			if(tipoMov.equals(TipoMovimentacaoEnum.COMPRA_JOGADOR)){
				desc.append("Compra do jogador ");
			}			
		}
		desc.append(financa.getJogador().getPosicao().getSigla());
		desc.append(" - ");
		desc.append(financa.getJogador().getNomeJogador());
		desc.append(" - ");
		desc.append(financa.getJogador().getNacionalidade().getDescricao());
		desc.append(" - ");
		desc.append(financa.getJogador().getLiga().getDescricao());
		
		financa.setDescricao(desc.toString());
	}

}
