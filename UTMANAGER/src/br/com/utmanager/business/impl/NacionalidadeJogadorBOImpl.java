package br.com.utmanager.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.NacionalidadeJogadorBO;
import br.com.utmanager.model.NacionalidadeJogador;

@Service
public class NacionalidadeJogadorBOImpl extends GenericBO implements NacionalidadeJogadorBO{

	@Override
	public List<NacionalidadeJogador> listarTodos() {
		// TODO Auto-generated method stub
		return getNacionalidadeJogadorDao().findAll();

	}

	@Override
	public void inserir(NacionalidadeJogador nacionalidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(NacionalidadeJogador nacionalidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(NacionalidadeJogador nacionalidade) {
		// TODO Auto-generated method stub
		
	}

}
