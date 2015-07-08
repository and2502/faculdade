package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Voo;

@Remote
public interface VooDAO extends DAO<Voo,Integer>{

	
}
