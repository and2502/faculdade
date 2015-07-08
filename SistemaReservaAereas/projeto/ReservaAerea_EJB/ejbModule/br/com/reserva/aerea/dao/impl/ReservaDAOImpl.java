package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.ReservaDAO;
import br.com.reserva.aerea.entity.Reserva;

@Stateless
public class ReservaDAOImpl extends DAOImpl<Reserva,Integer> implements ReservaDAO{


}
