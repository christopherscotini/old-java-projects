package br.com.utmanager.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.CategoriaJogadorBO;
import br.com.utmanager.model.CategoriaJogador;

@Service
public class CategoriaJogadorBOImpl extends GenericBO implements CategoriaJogadorBO{

	@Override
	public List<CategoriaJogador> listarTodos() {
		// TODO Auto-generated method stub
		return getCategoriaJogadorDao().findAll();
	}

	@Override
	public void inserir(CategoriaJogador categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(CategoriaJogador categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(CategoriaJogador categoria) {
		// TODO Auto-generated method stub
		
	}

}
