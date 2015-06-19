package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.NotaDAO;
import br.com.fiap.entity.Nota;

public class NotaDAOImpl extends DAOImpl<Nota, Long> implements NotaDAO{

	public NotaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
