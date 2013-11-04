package br.com.chris.sccgo.persistence.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import br.com.chris.sccgo.persistence.dao.Dao;


public class JpaGenericDao<T, ID extends Serializable> implements Dao<T, ID> {

	@PersistenceContext
	private EntityManager entityManager = null;
	private EntityManagerFactory emf;
	
	public JpaGenericDao() {
		emf = Persistence.createEntityManagerFactory("persistence-unit");
	}
	
	public void insert(T entity) {
		entityManager = getEntityManager();
		try{
			System.out.println("JpaGenericDao - Inserindo: "+entity.toString());
			//inicia o processo de transacao
			entityManager.getTransaction().begin();
			//faz a persistencia
			entityManager.persist(entity);
			//manda bala para o BD
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			//se der algo de errado vem parar aqui, onde é cancelado
			System.out.println("insert exception >>: "+e.getMessage());
			entityManager.getTransaction().rollback();
		}
		}

	public void update(T entity) {
		entityManager = getEntityManager();
		try {
			System.out.println("JpaGenericDao - Atualizando: "+entity.toString());
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
//			return true; opção para exibir se foi atualizado com sucesso
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
//			return false;
		} finally {
			entityManager.close();
		}	}

	public void delete(ID primaryKey) {
		entityManager = getEntityManager();
		try{
			T obj = entityManager.find(getGenericClass(), primaryKey);
			System.out.println("JpaGenericDao - Deletando: "+obj.getClass().getSimpleName()+" do ID:"+primaryKey);
			//inicia o processo de transacao
			entityManager.getTransaction().begin();
			// Remove a pessoa da base de dados.
			entityManager.remove(obj);
			// Finaliza a transação.
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println("exception >> "+e.getMessage());
		}
		finally {
			entityManager.close();
	    }
	}

	public List<T> findAll() {
		entityManager = getEntityManager();	
		System.out.println("JpaGenericDao - findAll: " + getGenericClass());
		CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getGenericClass());
		criteriaQuery.from(getGenericClass());
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public T findById(ID primaryKey) {
		entityManager = getEntityManager();	
		return entityManager.find(getGenericClass(), primaryKey);
	}

	private Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	

}
