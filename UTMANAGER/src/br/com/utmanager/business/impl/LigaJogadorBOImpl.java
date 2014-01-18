package br.com.utmanager.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.LigaJogadorBO;
import br.com.utmanager.model.LigaJogador;

@Service
public class LigaJogadorBOImpl  extends GenericBO implements LigaJogadorBO {

	@Override
	public List<LigaJogador> listarTodos() {
		
		return getLigaJogadorDao().findAll();
	}

	@Override
	public void inserir(LigaJogador liga) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editar(LigaJogador liga) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(LigaJogador liga) {
		// TODO Auto-generated method stub

	}

}
