package br.com.reserva.aerea.dao;

import javax.ejb.Remote;

import br.com.reserva.aerea.config.DAO;
import br.com.reserva.aerea.entity.Login;

@Remote
public interface LoginDAO extends DAO<Login,Integer>{

	Login autenticar(String email, String senha);
}
