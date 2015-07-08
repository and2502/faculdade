package br.com.reserva.aerea.config;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DAOImpl<T,K> implements DAO<T,K>{

	@PersistenceContext(unitName="CLIENT_MYSQL")
	protected EntityManager em;
	
	private Class<T> entityClass;
	
	@SuppressWarnings("all")
	public DAOImpl(){
		this.entityClass = (Class<T>) ((ParameterizedType) getClass() 
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
	}
	
	@Override
	public void insert(T entity) {
		em.persist(entity);
	}
	
	@Override
	public void removeById(K id){
		T entity = em.find(entityClass,id);
		em.remove(entity);
	}
	
	@Override
	public void remove(T entity) {
		//para forçar a entidade ser gerenciada pelo em
		em.merge(entity);
		em.remove(entity);
	}

	@Override
	public T searchByID(K id) {
		return em.find(entityClass, id);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

}
