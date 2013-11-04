package br.com.chris.sccgo.persistence.dao.jpa.cadastro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.chris.sccgo.model.Produto;
import br.com.chris.sccgo.model.Solicitacao;
import br.com.chris.sccgo.persistence.dao.cadastro.ISolicitacaoDao;
import br.com.chris.sccgo.persistence.dao.jpa.JpaGenericDao;


public class SolicitacaoDaoImpl extends JpaGenericDao<Solicitacao, Long> implements	ISolicitacaoDao {
	@PersistenceContext
	private EntityManager entityManager = null;
	
	@Override
	public List<Solicitacao> findBySolicitacoesPendentes() {
		entityManager = getEntityManager();
		try { 
				Query query = entityManager.createNamedQuery("Solicitacao.findBySolicitacoesPendentes");
//				TypedQuery<Solicitacao> typedQuery = entityManager.createNamedQuery(query, Solicitacao.class);
				return query.getResultList();
			} catch(EntityNotFoundException n) { 
				
			} catch (NonUniqueResultException no) { 
			
			} 
		return null;
	}

	@Override
	public List<Solicitacao> findBySolicitacoesFinalizadas() {
		entityManager = getEntityManager();
		try { 
			Query query = entityManager.createNamedQuery("Solicitacao.findBySolicitacoesFinalizadas");
//				TypedQuery<Solicitacao> typedQuery = entityManager.createNamedQuery(query, Solicitacao.class);
			return query.getResultList();
		} catch(EntityNotFoundException n) { 
			
		} catch (NonUniqueResultException no) { 
			
		} 
		return null;
	}
	
	
}
