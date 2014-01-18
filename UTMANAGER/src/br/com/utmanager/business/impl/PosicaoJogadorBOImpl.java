package br.com.utmanager.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.PosicaoJogadorBO;
import br.com.utmanager.model.PosicaoJogador;

@Service
public class PosicaoJogadorBOImpl  extends GenericBO implements PosicaoJogadorBO{

	@Override
	public List<PosicaoJogador> listarTodos() {

		return getPosicaoJogadorDao().findAll();
	}

	@Override
	public void inserir(PosicaoJogador posicao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(PosicaoJogador posicao) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deletar(PosicaoJogador posicao) {
		// TODO Auto-generated method stub
		
	}

}
