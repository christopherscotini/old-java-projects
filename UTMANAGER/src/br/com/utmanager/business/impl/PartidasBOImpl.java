package br.com.utmanager.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.PartidasBO;
import br.com.utmanager.model.Financa;
import br.com.utmanager.model.Partida;
import br.com.utmanager.model.TipoMovimentacaoEnum;
import br.com.utmanager.view.utils.DataUtils;

@Service
public class PartidasBOImpl extends GenericBO implements PartidasBO{

	@Override
	public List<Partida> listarTodos() {

		return getPartidaDao().findAll();
	}

	@Override
	public void inserir(Partida partida) {
		partida.setDataPartida(new Date());
		Partida partidaReturn = getPartidaDao().insert(partida);
		calculaFinancas(partidaReturn, TipoMovimentacaoEnum.GANHO_PARTIDA);
		
		
	}

	@Override
	public void editar(Partida partida) {
		
	}

	@Override
	public void deletar(Partida partida) {
		// TODO Auto-generated method stub
	}
	
	private void calculaFinancas(Partida partida, TipoMovimentacaoEnum tipoMov) {
		Financa financa = new Financa();
		
		financa.setPartida(partida);
		financa.setValorMovimentado(partida.getValorGanhoPartida());
		financa.setDataMovimentacao(new Date());
		financa.setValorAtual(getFinancaDao().getSaldoAtual().add(financa.getValorMovimentado()));
		financa.setDescricao(partida.getDescricaoPartida() + " em "+DataUtils.parseString(partida.getDataPartida(), "dd/MM/yyyy - HH:mm") );
		
		getFinancaDao().insert(financa);
	}

}
