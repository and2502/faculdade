package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.CursoAlunoDAO;
import br.com.fiap.entity.CursoAluno;

public class CursoAlunoDAOImpl extends DAOImpl<CursoAluno, Long> implements CursoAlunoDAO{

	public CursoAlunoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
