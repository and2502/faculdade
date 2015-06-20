package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.entity.Disciplina;

public class DisciplinaDAOImpl extends DAOImpl<Disciplina, Long> implements DisciplinaDAO{

	public DisciplinaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Disciplina> findDisciplinasByCurso(Long idCurso) {
		TypedQuery<Disciplina> query = em.createQuery("from Disciplina d where d.curso.id = :idCurso", Disciplina.class);
		query.setParameter("idCurso", idCurso);
		return query.getResultList();
	}


}
