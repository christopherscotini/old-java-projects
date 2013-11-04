package br.com.todo.gpes.persistence.dao.jpa.cadastro;

import org.springframework.stereotype.Repository;

import br.com.todo.gpes.model.cadastro.Cliente;
import br.com.todo.gpes.persistence.dao.cadastro.ClienteDao;
import br.com.todo.gpes.persistence.dao.jpa.JpaGenericDao;

@Repository
public class ClienteDaoImpl extends JpaGenericDao<Cliente, Integer> implements ClienteDao {

}
