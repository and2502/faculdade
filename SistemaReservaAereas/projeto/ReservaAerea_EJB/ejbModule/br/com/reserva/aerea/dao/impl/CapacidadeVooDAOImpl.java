package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.CapacidadeVooDAO;
import br.com.reserva.aerea.entity.CapacidadeVoo;

@Stateless
public class CapacidadeVooDAOImpl extends DAOImpl<CapacidadeVoo,Integer> implements CapacidadeVooDAO{

	@Override
	public CapacidadeVoo findCapacidadeVooExecutivoByIdVoo(Integer id) {
		TypedQuery<CapacidadeVoo> query = em.createQuery("from CapacidadeVoo c where c.classe.idClasse = 2 and c.voo.idVoo = :idVoo", CapacidadeVoo.class);
		query.setParameter("idVoo", id);
		query.setHint("org.hibernate.cacheable","true");
		return query.getSingleResult();
	}

	@Override
	public CapacidadeVoo findCapacidadeVooEconomicoByIdVoo(Integer id) {
		TypedQuery<CapacidadeVoo> query = em.createQuery("from CapacidadeVoo c where c.classe.idClasse = 1 and c.voo.idVoo = :idVoo", CapacidadeVoo.class);
		query.setParameter("idVoo", id);
		query.setHint("org.hibernate.cacheable","true");
		return query.getSingleResult();
	}


}
