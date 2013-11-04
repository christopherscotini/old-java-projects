package br.com.contestacao.persistence.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.contestacao.persistence.Dao;

public class JpaGenericDao implements Dao {

	@PersistenceContext
	private EntityManager entityManager = null;

	@Override
	public <T extends EntityPersistence> T save(T entity) {
		if (entity instanceof AuditEntityPersistence) {
			AuditEntityPersistence audit = (AuditEntityPersistence) entity;
			Date now = new Date();
			if (isNewEntity(entity)) {
				audit.setCreatedDate(now);
			}
			audit.setUpdatedDate(now);
		}

		if (isNewEntity(entity)) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}
		entityManager.flush();
		return entity;
	}

	@Override
	public <T extends EntityPersistence> void remove(T entity) {
		entityManager.remove(entity);
	}
	
	private <T extends EntityPersistence> boolean isNewEntity(T entity) {
		return entity.getPrimaryKey() == null;
	}

	@Override
	public <T extends EntityPersistence> List<T> findAll(Class<T> entityClass) {
		CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(entityClass);
		criteriaQuery.from(entityClass);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public <T extends EntityPersistence> List<T> findAll(CriteriaQuery<T> criteriaQuery) {
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public <T extends EntityPersistence> T find(CriteriaQuery<T> criteriaQuery) {
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	@Override
	public <T extends EntityPersistence, P extends Serializable> T findById(Class<T> entityClass, P primaryKey) {
		return entityManager.find(entityClass, primaryKey);
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}
}
