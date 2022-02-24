package com.bookstore.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {

	protected EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {

		super();
		this.entityManager = entityManager;
	}

	public E create(E entity) {

		entityManager.getTransaction().begin();

		entityManager.persist(entity);

		entityManager.flush();

		entityManager.refresh(entity);

		entityManager.getTransaction().commit();

		return entity;
	}

	public E update(E entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		return entity;
	}

	public E find(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);
		if (entity != null) {
			entityManager.refresh(entity);
		}
		return entity;
	}

	public void delete(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);

		entityManager.getTransaction().begin();
		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		entityManager.getTransaction().commit();

	}

	public List<E> findWithNameQuery(String queryName) {

		Query query = entityManager.createNamedQuery(queryName);

		return query.getResultList();

	}

	public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {

		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);

		return query.getResultList();

	}

	public long countWithNamedQuery(String queryName) {

		Query query = entityManager.createNamedQuery(queryName);

		return (long) query.getSingleResult();
	}

}
