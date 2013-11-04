package br.com.chris.sccgo.persistence.dao.jpa.cadastro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.chris.sccgo.model.Produto;
import br.com.chris.sccgo.model.Solicitacao;
import br.com.chris.sccgo.persistence.dao.cadastro.IProdutoDao;
import br.com.chris.sccgo.persistence.dao.jpa.JpaGenericDao;

public class ProdutoDaoImpl extends JpaGenericDao<Produto, Long> implements	IProdutoDao {

	@PersistenceContext
	private EntityManager entityManager = null;
	


}
