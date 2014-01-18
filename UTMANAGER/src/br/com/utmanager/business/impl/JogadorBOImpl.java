package br.com.utmanager.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.JogadorBO;
import br.com.utmanager.model.Jogador;

@Service
public class JogadorBOImpl extends GenericBO implements JogadorBO{

	@Override
	public void inserir(Jogador plantel) {
		plantel.setDataEntrada(new Date());
		getJogadorDao().insert(plantel);
	}

	@Override
	public void editar(Jogador plantel) {
		plantel.setDataAlteracao(new Date());
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

}
