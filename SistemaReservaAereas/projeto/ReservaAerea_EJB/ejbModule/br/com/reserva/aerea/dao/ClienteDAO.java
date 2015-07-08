package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Cliente;

@Remote
public interface ClienteDAO extends DAO<Cliente,Integer>{

	
}
