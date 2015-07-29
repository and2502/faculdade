package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.AssentoDAO;
import br.com.reserva.aerea.entity.Assento;

@Stateless
public class AssentoDAOImpl extends DAOImpl<Assento,Integer> implements AssentoDAO{

	@Override
	public Assento findAssentoByNrAndClasse(Integer nrAssento, String posicao) {
		TypedQuery<Assento> query = em.createQuery("from Assento a WHERE a.nrAssento = :nrAssento AND a.posicao = :posicao", Assento.class);
		query.setParameter("nrAssento", String.valueOf(nrAssento));
		query.setParameter("posicao", posicao);
		return query.getSingleResult();
	}

	@Override
	public boolean isDisponivel(Integer idTrecho, String posicao, int nrAssento) {
		TypedQuery<Object> query = em.createQuery("from Reserva r where r.trecho.idTrecho = :idTrecho and r.assento.nrAssento = :nrAssento and r.assento.posicao = :posicao ", Object.class);
		query.setParameter("idTrecho", idTrecho);
		query.setParameter("nrAssento", String.valueOf(nrAssento));
		query.setParameter("posicao", posicao);
		return query.getResultList().size() > 0;
	}


}
