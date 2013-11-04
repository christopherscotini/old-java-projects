package br.com.contestacao.service.impl;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.model.Tela;
import br.com.contestacao.persistence.dao.TelaDao;
import br.com.contestacao.service.TelaService;

@Stateless
public class TelaServiceImpl implements TelaService {

	private static final long serialVersionUID = 5238891621465598093L;

	@Inject
	private TelaDao telaDao = null;

	@Override
	public List<Tela> listar() {
		return telaDao.findAll();
	}

	@Override
	public Set<String> buscarPorUsuarioLogin(String login) {
		return telaDao.findByUsuarioLogin(login);
	}
	
}
