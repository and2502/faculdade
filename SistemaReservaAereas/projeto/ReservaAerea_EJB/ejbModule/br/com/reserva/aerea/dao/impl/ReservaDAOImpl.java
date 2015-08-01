package br.com.reserva.aerea.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Schedule;
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

	@Override
	@Schedule(second="*/30", minute="*", hour="*")
	public List<Object[]> getQtdeReservationsByStretch() {
		List<Object[]> results = em.createQuery("select r.trecho.aeroportoOrigem.localizacao, r.trecho.aeroportoDestino.localizacao,"
				+ " count(r.trecho.idTrecho) from Reserva r where r.trecho.horarioPartida >= :sysDate "
				+ "group by r.trecho.aeroportoOrigem.localizacao, r.trecho.aeroportoDestino.localizacao order by count(r.trecho.idTrecho) desc").
		setParameter("sysDate", Calendar.getInstance()).getResultList();
		System.out.println("---------------- Quantidade de passagens vendidas até o momento, por trecho -----------------------------------");
		for (Object[] result : results) {
		    String origem = (String) result[0];
		    String destino = (String) result[1];
		    Long qtdeReservasVendidas = (Long) result[2];
		    System.out.println("Origem: "+origem+" - Destino: "+destino+" - Qtde. vendidas: "+qtdeReservasVendidas);
		}
		return results;
	}

}
