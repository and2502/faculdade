package br.com.reserva.aerea.dao.impl;

import javax.ejb.Stateless;

import br.com.reserva.aerea.config.DAOImpl;
import br.com.reserva.aerea.dao.ClasseDAO;
import br.com.reserva.aerea.entity.Classe;

@Stateless
public class ClasseDAOImpl extends DAOImpl<Classe,Integer> implements ClasseDAO{


}
