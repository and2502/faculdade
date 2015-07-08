package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.AssentoDAO;
import br.com.reserva.aerea.entity.Assento;

@Stateless
public class AssentoDAOImpl extends DAOImpl<Assento,Integer> implements AssentoDAO{


}
