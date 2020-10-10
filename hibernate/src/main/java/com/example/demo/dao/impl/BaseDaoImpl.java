package com.example.demo.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import com.example.demo.dao.BaseDao;

public class BaseDaoImpl<E> implements BaseDao<E> {

	private final Class<E> entityClass;

	public Session session;

	@PersistenceContext
	private EntityManager entityManager;

	public BaseDaoImpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Session getSession() {
		session = this.entityManager.unwrap(Session.class);
		if (session.getTransaction().isActive()) {
			return session;
		}

		session.beginTransaction();
		return session;
	}

	@Override
	public void saveOrUpdate(E entity) {
		session = getSession();
		session.saveOrUpdate(entity);
	}

	@Override
	public void deleteAll() {
		session = getSession();
		List<E> entities = findAll();
		for (E entity : entities) {
			session.delete(entity);
		}
	}

	@Override
	public List<E> findAll() {
		session = getSession();
		return session.createCriteria(this.entityClass).list();
	}

	@Override
	public E findById(Serializable id) {
		session = getSession();
		return session.get(this.entityClass, id);
	}

	@Override
	public boolean deleteById(Class<?> type, Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

}
