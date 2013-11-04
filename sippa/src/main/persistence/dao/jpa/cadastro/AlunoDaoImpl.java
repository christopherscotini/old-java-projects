package persistence.dao.jpa.cadastro;

import org.springframework.stereotype.Repository;

import model.cadastro.Aluno;
import persistence.dao.cadastro.AlunoDao;
import persistence.dao.jpa.JpaGenericDao;


@Repository
public class AlunoDaoImpl  extends JpaGenericDao<Aluno, Long> implements AlunoDao{
 
	@Override
	public Aluno buscarPorDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
