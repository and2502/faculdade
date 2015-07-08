package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Trecho;

@Remote
public interface TrechoDAO extends DAO<Trecho,Integer>{

	
}
