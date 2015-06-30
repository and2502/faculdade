package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.config.DAOImpl;
import br.com.fiap.dao.NotaDAO;
import br.com.fiap.entity.Nota;

public class NotaDAOImpl extends DAOImpl<Nota, Long> implements NotaDAO{

	public NotaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Nota> notas() {
		
		TypedQuery<Nota> query = em.createQuery("from Nota n left join fetch n.aluno a left join fetch n.disciplina d left join fetch d.curso", Nota.class);		
		return query.getResultList();
	}

}
