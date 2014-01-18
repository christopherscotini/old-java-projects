package br.com.utmanager.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.utmanager.business.GenericBO;
import br.com.utmanager.business.bo.StatusJogadorBO;
import br.com.utmanager.model.StatusJogador;

@Service
public class StatusJogadorBOImpl extends GenericBO implements StatusJogadorBO{

	@Override
	public List<StatusJogador> listarTodos() {
		// TODO Auto-generated method stub
		return getStatusJogadorDao().findAll();
	}

	@Override
	public void inserir(StatusJogador categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(StatusJogador categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(StatusJogador categoria) {
		// TODO Auto-generated method stub
		
	}

}
