package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.LoginDAO;
import br.com.reserva.aerea.entity.Login;

@Stateless
public class LoginDAOImpl extends DAOImpl<Login,Integer> implements LoginDAO{

	@Override
	public Login autenticar(String email, String senha){
		TypedQuery<Login> query = em.createQuery("from Login where usuario = :paramEmail and senha = :paramSenha", Login.class);
		query.setParameter("paramEmail", email.trim());
		query.setParameter("paramSenha", senha.trim());
		Login login;
		try{
			login = query.getSingleResult();
		}catch(NoResultException ex){
			login = null;
		}
		return login;
	}


}
