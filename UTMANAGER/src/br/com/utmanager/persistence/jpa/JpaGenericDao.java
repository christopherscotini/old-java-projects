package br.com.utmanager.persistence.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import br.com.utmanager.persistence.Dao;

public class JpaGenericDao<T, ID extends Serializable> implements Dao<T, ID> {

	@PersistenceContext(name="utmanagerPU")
	private EntityManager entityManager = null;

	@Transactional
	public T insert(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public T update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public void delete(T entity) {
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
	}
	
	@Transactional
	public List<T> findAll() {
		CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getGenericClass());
		criteriaQuery.from(getGenericClass());
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Transactional
	public T findById(ID primaryKey) {
		return entityManager.find(getGenericClass(), primaryKey);
	}

	@Transactional
	public void saveAll(List<T> entities) {
		for (int i = 0; i < entities.size(); i++) {
            entityManager.persist(entities.get(i));
            if ( i % 20 == 0 ) {
                entityManager.flush();
                entityManager.clear();
            }
        }
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected String getGenericClauseSelectAll(String entityName, String alias){
		StringBuilder genericQuerySelectAll = new StringBuilder();
		genericQuerySelectAll.append("SELECT ");
		genericQuerySelectAll.append(alias+" ");
		genericQuerySelectAll.append("FROM ");
		genericQuerySelectAll.append(entityName+" ");
		genericQuerySelectAll.append(alias+" ");

		return genericQuerySelectAll.toString();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
