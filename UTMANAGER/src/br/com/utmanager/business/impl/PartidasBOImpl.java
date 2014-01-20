package br.com.utmanager.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.PartidasBO;
import br.com.utmanager.model.Financa;
import br.com.utmanager.model.Partida;

@Service
public class PartidasBOImpl extends GenericBO implements PartidasBO{

	@Override
	public List<Partida> listarTodos() {

		return getPartidaDao().findAll();
	}

	@Override
	public void inserir(Partida partida) {
		getPartidaDao().insert(partida);
		
		Financa financa = new Financa();
		financa.setValorMovimentado(partida.getValorGanhoPartida());
		financa.setValorAtual(getFinancaDao().getSaldoAtual().add(financa.getValorMovimentado()));
		financa.setDataMovimentacao(new Date());
		getFinancaDao().insert(financa);
		
	}

	@Override
	public void editar(Partida partida) {
		
	}

	@Override
	public void deletar(Partida partida) {
		// TODO Auto-generated method stub
		
	}

}
