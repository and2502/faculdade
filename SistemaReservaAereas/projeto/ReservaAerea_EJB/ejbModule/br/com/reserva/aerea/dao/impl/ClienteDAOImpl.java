package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.ClienteDAO;
import br.com.reserva.aerea.entity.Cliente;

@Stateless
public class ClienteDAOImpl extends DAOImpl<Cliente,Integer> implements ClienteDAO{


}
