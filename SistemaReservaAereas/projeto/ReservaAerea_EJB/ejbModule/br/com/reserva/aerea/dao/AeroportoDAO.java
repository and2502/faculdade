package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Aeroporto;

@Remote
public interface AeroportoDAO extends DAO<Aeroporto,Integer>{

	
}
