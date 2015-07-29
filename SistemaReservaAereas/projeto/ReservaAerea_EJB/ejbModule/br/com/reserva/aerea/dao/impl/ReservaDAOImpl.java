package br.com.reserva.aerea.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.ReservaDAO;
import br.com.reserva.aerea.entity.Reserva;

@Stateless
public class ReservaDAOImpl extends DAOImpl<Reserva,Integer> implements ReservaDAO{

	@Override
	public List<Reserva> findAllReservationByUserLogged(Integer idCliente) {
		TypedQuery<Reserva> query = em.createQuery("from Reserva r where r.cliente.idCliente = :idCliente order by r.trecho.horarioPartida desc ", Reserva.class);
		query.setParameter("idCliente", idCliente);
		return query.getResultList();
	}

}
