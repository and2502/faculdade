package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.entity.Disciplina;

public class DisciplinaDAOImpl extends DAOImpl<Disciplina, Long> implements DisciplinaDAO{

	public DisciplinaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
