package br.com.reserva.aerea.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.TrechoDAO;
import br.com.reserva.aerea.entity.Trecho;

@Stateless
public class TrechoDAOImpl extends DAOImpl<Trecho,Integer> implements TrechoDAO{

	@Override
	public List<Trecho> findAll() {
		TypedQuery<Trecho> query = em.createQuery("from Trecho t WHERE t.horarioPartida >= :sysDate order by t.horarioPartida desc ", Trecho.class);
		query.setParameter("sysDate", Calendar.getInstance());
		return query.getResultList();
	}


}
