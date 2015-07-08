package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.VooDAO;
import br.com.reserva.aerea.entity.Voo;

@Stateless
public class VooDAOImpl extends DAOImpl<Voo,Integer> implements VooDAO{


}
