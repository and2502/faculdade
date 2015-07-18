package br.com.reserva.aerea.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Aeroporto;

@Remote
public interface AeroportoDAO extends DAO<Aeroporto,Integer>{

	List<Aeroporto> findAll();
	
}
