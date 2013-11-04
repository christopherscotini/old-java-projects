package br.com.todo.gpes.persistence.dao.jpa.cadastro;

import org.springframework.stereotype.Repository;

import br.com.todo.gpes.model.cadastro.Funcionario;
import br.com.todo.gpes.persistence.dao.cadastro.FuncionarioDao;
import br.com.todo.gpes.persistence.dao.jpa.JpaGenericDao;

@Repository
public class FuncionarioDaoImpl extends JpaGenericDao<Funcionario, Long> implements FuncionarioDao {

}
