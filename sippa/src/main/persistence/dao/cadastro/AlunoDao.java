package persistence.dao.cadastro;

import persistence.dao.Dao;
import model.cadastro.Aluno;

public interface AlunoDao extends Dao<Aluno, Long>{
	
	Aluno buscarPorDescricao(String descricao);

}
