package br.com.reserva.aerea.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.AeroportoDAO;
import br.com.reserva.aerea.entity.Aeroporto;

@Stateless
public class AeroportoDAOImpl extends DAOImpl<Aeroporto,Integer> implements AeroportoDAO{

	@Override
	public List<Aeroporto> findAll() {
		TypedQuery<Aeroporto> query = em.createQuery("from Aeroporto", Aeroporto.class);
		return query.getResultList();
	}


}
