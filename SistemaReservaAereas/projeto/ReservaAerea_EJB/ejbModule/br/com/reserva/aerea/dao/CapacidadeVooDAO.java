package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.CapacidadeVoo;

@Remote
public interface CapacidadeVooDAO extends DAO<CapacidadeVoo,Integer>{

	CapacidadeVoo findCapacidadeVooExecutivoByIdVoo(Integer id);
	
	CapacidadeVoo findCapacidadeVooEconomicoByIdVoo(Integer id);
	
}
