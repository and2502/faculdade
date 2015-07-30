package br.com.reserva.aerea.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Assento;

@Remote
public interface AssentoDAO extends DAO<Assento,Integer>{

	/**
	 * Metodo responsavel por buscar o Assento por
	 * @param nrAssento
	 * @param posicao - Posição ["A","B","C","D","F"]
	 * @return Assento
	 */
	Assento findAssentoByNrAndPosicao(Integer nrAssento, String posicao);
	
	List<Assento> findAll();

	/**
	 * Metodo responsavel por validar se o assento está disponivel ou não
	 * para reserva.
	 * @param idTrecho
	 * @param posicao - Posição do assento["A", "B", "C", "D", "F"]
	 * @param nrAssento
	 * @return true or false
	 */
	boolean isDisponivel(Integer idTrecho, String posicao, int nrAssento);
}
