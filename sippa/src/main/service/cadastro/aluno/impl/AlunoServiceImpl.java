package service.cadastro.aluno.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistence.dao.cadastro.AlunoDao;

import model.cadastro.Aluno;
import service.cadastro.aluno.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoDao daoAluno = null;
	
	@Override
	public void adicionaAluno(Aluno aluno) {
		
		
		daoAluno.insert(aluno);
		
	}
	
}
