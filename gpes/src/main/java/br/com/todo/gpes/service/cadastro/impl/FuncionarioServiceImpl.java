package br.com.todo.gpes.service.cadastro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.gpes.model.cadastro.Funcionario;
import br.com.todo.gpes.persistence.dao.cadastro.FuncionarioDao;
import br.com.todo.gpes.service.cadastro.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao funcionarioDao = null;

	public List<Funcionario> obterFuncionarios() {
		return funcionarioDao.findAll();
	}

	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

}
