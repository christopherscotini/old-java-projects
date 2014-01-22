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
import br.com.utmanager.model.StatusJogadorEnum;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.view.utils.GlobalUtils;

@Service
public class JogadorBOImpl extends GenericBO implements JogadorBO{

	@Override
	public void inserir(Jogador jogador) {
		
		verificaForm(jogador);
		
		jogador.setDataEntrada(new Date());
		
		if(jogador.getTipoMovJogador().getCodigo().equals(TipoMovimentacaoEnum.VENDA_JOGADOR)){
			jogador.setDataSaida(new Date());
			calculoLucroJogador(jogador);
		}
		
		jogador = getJogadorDao().insert(jogador);
		
		atualizarFinanceiro(jogador);
		
//		calculaFinancas(jogador, TipoMovimentacaoEnum.COMPRA_JOGADOR);
	}

	@Override
	public void editar(Jogador jogador) {
		verificaForm(jogador);
		
		jogador.setDataAlteracao(new Date());
		if(jogador.getStatus().getId().equals(StatusJogadorEnum.VENDIDO.getCodigo())){
			jogador.setDataSaida(jogador.getDataSaida()==null?new Date():jogador.getDataSaida());
			calculoLucroJogador(jogador);
		}
		
		jogador = getJogadorDao().update(jogador);
		
		atualizarFinanceiro(jogador);
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
	
	private void atualizarFinanceiro(Jogador jogador) {
		Financa financa = new Financa();
		if(!jogador.isVendido()){
			if(jogador.getTipoMovJogador() != null){
				if(jogador.getTipoMovJogador().getCodigo().equals(TipoMovimentacaoEnum.VENDA_JOGADOR.getCodigo())){
					calcularFinanceiroVenda(jogador, financa);
				}else{
					calcularFinanceiroCompra(jogador, financa);
				}
			}
		}else{
//			calculaValorMovimentadoFinanca(financa, jogador);
//			financa.setValorAtual(financa.getValorAtual().add(financa.getValorMovimentado()));
//			addDescricaoFinanca(financa, tipoMov);
//			getFinancaDao().update(financa);
		}
		
	}
	


	private void calcularFinanceiroCompra(Jogador jogador, Financa financa) {
		financa.setValorMovimentado(GlobalUtils.verificaBigDecimalNulo(jogador.getValorPago()));
		financa.setValorAtual(getFinancaDao().getSaldoAtual().subtract(financa.getValorMovimentado()));
		financa.setDataMovimentacao(new Date());
		financa.setTipoMovimentacao(jogador.getTipoMovJogador());
		financa.setJogador(jogador);
		addDescricaoFinanca(financa, jogador);
		getFinancaDao().insert(financa);
	}

	private void calcularFinanceiroVenda(Jogador jogador, Financa financa) {
		BigDecimal valorVenda5Porcento = GlobalUtils.verificaBigDecimalNulo(jogador.getValorVenda()).multiply(new BigDecimal("0.05"));
		BigDecimal valorVendaDescontado = GlobalUtils.verificaBigDecimalNulo(jogador.getValorVenda()).subtract(valorVenda5Porcento);
		financa.setValorMovimentado(valorVendaDescontado);
		financa.setValorAtual(getFinancaDao().getSaldoAtual().add(financa.getValorMovimentado()));
		financa.setDataMovimentacao(new Date());
		financa.setTipoMovimentacao(jogador.getTipoMovJogador());
		financa.setJogador(jogador);
		addDescricaoFinanca(financa, jogador);
		getFinancaDao().insert(financa);
	}



	private void calculoLucroJogador(Jogador jogador){
		BigDecimal valorVenda5Porcento = jogador.getValorVenda().multiply(new BigDecimal("0.05"));
		BigDecimal valorVendaDescontado = jogador.getValorVenda().subtract(valorVenda5Porcento);
		jogador.setLucro(valorVendaDescontado.subtract(jogador.getValorPago()));
	
	}

	private void verificaForm(Jogador jogador) {
		if(jogador.getTipoMovJogador() != null){
			if(jogador.getTipoMovJogador().getCodigo().equals(TipoMovimentacaoEnum.VENDA_JOGADOR.getCodigo())){
				if(GlobalUtils.isBigDecimalNullOrZero(jogador.getValorVenda())){
					if(jogador.getStatus().equals(StatusJogadorEnum.VENDIDO.getCodigo())){
						throw new FormInconsistenteException("Adicione um valor de venda.");
					}
				}else{
					if(!jogador.getStatus().getId().equals(StatusJogadorEnum.VENDIDO.getCodigo())){
						throw new FormInconsistenteException("Marque o STATUS como VENDIDO.");
					}
				}
			}
		}else{
			if(!jogador.getStatus().getId().equals(StatusJogadorEnum.VENDIDO.getCodigo())){
				if(GlobalUtils.isBigDecimalNullOrZero(jogador.getValorVenda())){
					if(jogador.getStatus().equals(StatusJogadorEnum.VENDIDO.getCodigo())){
						throw new FormInconsistenteException("Adicione um valor de venda.");
					}
				}else{
					if(!jogador.getStatus().getId().equals(StatusJogadorEnum.VENDIDO.getCodigo())){
						throw new FormInconsistenteException("Marque o STATUS como VENDIDO.");
					}
				}
			}
		}
	}
	
	private void addDescricaoFinanca(Financa financa, Jogador jogador){
		StringBuilder desc = new StringBuilder();
		if(jogador.getTipoMovJogador().equals(TipoMovimentacaoEnum.VENDA_JOGADOR)){
			desc.append("Venda do jogador ");
		}else{
			if(jogador.getTipoMovJogador().equals(TipoMovimentacaoEnum.COMPRA_JOGADOR)){
				desc.append("Compra do jogador ");
			}			
		}
		
		jogador = getJogadorDao().findById(jogador.getId());
		
		desc.append(jogador.getPosicao().getSigla());
		desc.append(" - ");
		desc.append(jogador.getNomeJogador());
		desc.append(" - ");
		desc.append(jogador.getNacionalidade().getDescricao());
		desc.append(" - ");
		desc.append(jogador.getLiga().getDescricao());
		
		financa.setDescricao(desc.toString());
	}

}
