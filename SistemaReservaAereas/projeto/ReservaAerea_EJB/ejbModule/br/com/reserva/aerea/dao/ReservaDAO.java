package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Reserva;

@Remote
public interface ReservaDAO extends DAO<Reserva, Integer>{
}
