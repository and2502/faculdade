package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;

public class AlunoDAOImpl extends DAOImpl<Aluno, Long> implements AlunoDAO{

	public AlunoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Aluno> findAllAlunos() {
		TypedQuery<Aluno> query = em.createQuery("from Aluno", Aluno.class);
		return query.getResultList();
	}

	@Override
	public List<Aluno> findAllAlunosByCurso(Long idCurso) {
		TypedQuery<Aluno> query = em.createQuery("select a from Aluno a, CursoAluno ca where ca.aluno.id = a.id and ca.curso.id = :paramIdCurso", Aluno.class);
		query.setParameter("paramIdCurso", idCurso);
		return query.getResultList();
	}
}
