package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Assento;

@Remote
public interface AssentoDAO extends DAO<Assento,Integer>{

	Assento findAssentoByNrAndClasse(Integer nrAssento, String posicao);
}
