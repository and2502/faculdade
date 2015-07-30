package br.com.reserva.aerea.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.AssentoDAO;
import br.com.reserva.aerea.entity.Assento;

@Stateless
public class AssentoDAOImpl extends DAOImpl<Assento,Integer> implements AssentoDAO{

	@Override
	public Assento findAssentoByNrAndPosicao(Integer nrAssento, String posicao) {
		if(nrAssento == null || posicao == null){
			throw new IllegalArgumentException("Os parametros nrAssento e posicao não podem ser nulos");
		}
		List<Assento> assentos = findAll();
		for (Assento assento : assentos) {
			if(String.valueOf(nrAssento).equalsIgnoreCase(assento.getNrAssento()) &&
					posicao.equalsIgnoreCase(assento.getPosicao())){
				return assento;
			}
		}
		return null;
	}

	@Override
	public boolean isDisponivel(Integer idTrecho, String posicao, int nrAssento) {
		TypedQuery<Object> query = em.createQuery("from Reserva r where r.trecho.idTrecho = :idTrecho and r.assento.nrAssento = :nrAssento and r.assento.posicao = :posicao ", Object.class);
		query.setParameter("idTrecho", idTrecho);
		query.setParameter("nrAssento", String.valueOf(nrAssento));
		query.setParameter("posicao", posicao);
		return query.getResultList().size() <= 0;
	}

	@Override
	public List<Assento> findAll() {
		TypedQuery<Assento> query = em.createQuery("from Assento", Assento.class);
		query.setHint("org.hibernate.cacheable","true");
		return query.getResultList();
	}


}
