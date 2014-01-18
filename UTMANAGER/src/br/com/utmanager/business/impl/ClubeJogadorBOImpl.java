package br.com.utmanager.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.ClubeJogadorBO;
import br.com.utmanager.model.ClubeJogador;
import br.com.utmanager.view.utils.GlobalUtils;

@Service
public class ClubeJogadorBOImpl extends GenericBO implements ClubeJogadorBO{

	@Override
	public List<ClubeJogador> listarTodos() {
		// TODO Auto-generated method stub
		return getClubeJogadorDao().findAll();
	}

	@Override
	public void inserir(ClubeJogador categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(ClubeJogador categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(ClubeJogador categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClubeJogador> filtrarPorLiga(Long clube) {
		clube = GlobalUtils.verificaLongNulo(clube);
		
		return getClubeJogadorDao().findByLeague(clube);
	}

}
