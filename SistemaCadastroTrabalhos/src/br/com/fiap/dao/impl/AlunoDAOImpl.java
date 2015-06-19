package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;

public class AlunoDAOImpl extends DAOImpl<Aluno, Long> implements AlunoDAO{

	public AlunoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
