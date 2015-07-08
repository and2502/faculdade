package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Classe;

@Remote
public interface ClasseDAO extends DAO<Classe,Integer>{

	
}
