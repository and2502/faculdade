package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.CursoDAO;
import br.com.fiap.entity.Curso;

public class CursoDAOImpl extends DAOImpl<Curso, Long> implements CursoDAO{

	public CursoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Curso> findAllCursos() {
		TypedQuery<Curso> query = em.createQuery("from Curso", Curso.class);
		return query.getResultList();
	}

	@Override
	public boolean verifyHasCursos() {
		TypedQuery<Long> query = em.createQuery("SELECT count(id) as qtde FROM Curso", Long.class);
		Long qtde = query.getSingleResult();
		if(qtde > 0){
			return true;
		}else{
			return false;
		}
	}

}
