package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.AeroportoDAO;
import br.com.reserva.aerea.entity.Aeroporto;

@Stateless
public class AeroportoDAOImpl extends DAOImpl<Aeroporto,Integer> implements AeroportoDAO{


}
