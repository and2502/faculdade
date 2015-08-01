package br.com.reserva.aerea.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Schedule;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Reserva;

@Remote
public interface ReservaDAO extends DAO<Reserva, Integer>{
	
	List<Reserva> findAllReservationByUserLogged(Integer idLogin);
	
	List<Object[]> getQtdeReservationsByStretch();
}
