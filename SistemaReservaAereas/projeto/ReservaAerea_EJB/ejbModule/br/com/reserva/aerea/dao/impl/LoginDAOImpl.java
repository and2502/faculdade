package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.LoginDAO;
import br.com.reserva.aerea.entity.Login;

@Stateless
public class LoginDAOImpl extends DAOImpl<Login,Integer> implements LoginDAO{


}
